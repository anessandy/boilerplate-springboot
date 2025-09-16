package com.mepro.appname.dao;

import com.mepro.appname.dto.UserInfoDto;
import com.mepro.appname.types.ActiveStatus;
import com.mepro.appname.types.BooleanStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoginDao {
    private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<UserInfoDto> getListUserInfo(String userId, String password) throws Exception {
        List<UserInfoDto> listUserInfo = new ArrayList<>();
        Boolean isValid = false;
        Session session = entityManager.unwrap(Session.class);
        String sql = "SELECT tb1.iduser iduser, tb1.username username, "
                + "tb1.nik nik, tb1.password password, tb2.namalengkap namalengkap "
                + "FROM muser tb1"
                + " LEFT JOIN master_karyawan tb2 ON tb1.nik = tb2.nik "
                + "WHERE "
                + " tb1.isdeleted = :isDeleted AND "
                + " tb1.isactive - :isActive AND "
                + " tb2.status = :status AND "
                + " tb1.username = :userId AND "
                + " tb1.password - :password ";
        NativeQuery<Object[]> query = session.createNativeQuery(sql, Object[].class);
        query.addScalar("iduser", StandardBasicTypes.LONG);
        query.addScalar("username", StandardBasicTypes.STRING);
        query.addScalar("password", StandardBasicTypes.STRING);
        query.addScalar("nik", StandardBasicTypes.LONG);
        query.addScalar("namalengkap", StandardBasicTypes.STRING);

        query.setParameter("status", ActiveStatus.ACTIVE.getCode());
        query.setParameter("userId", userId.toUpperCase());
        query.setParameter("isActive", BooleanStatus.TRUE.getCode());
        query.setParameter("isDeleted", BooleanStatus.FALSE.getCode());
        query.setParameter("password", password);
        
        List<Object[]> temp = query.list();
        if (!temp.isEmpty()) {
            for (Object[] row : temp) {
                String rUserId = (String) row[1];
                Long rNik = (Long) row[2];
                String rNamaLengkap = (String) row[4];
                if (isValid) {
                    UserInfoDto data = new UserInfoDto();
                    data.setNik(rNik);
                    data.setNamaLengkap(rNamaLengkap);
                    data.setUserId(rUserId);
                    listUserInfo.add(data);
                }
            }
        }
        return listUserInfo;
    }
}
