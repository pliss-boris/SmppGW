package com.pb.SmppGatway.dao.mem.model.imp;

import com.pb.SmppGatway.dao.mem.domain.SmsEntity;
import com.pb.SmppGatway.dao.mem.model.SmsModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Boris on 10/19/2015.
 */
@Repository
@Transactional
public class SmsModelImpl implements SmsModel {
    @PersistenceContext(unitName = "mem-PU")
    private EntityManager em;

    @Override
    public List<SmsEntity> getAll() {
        return em.createNamedQuery("SmsEntity.all", SmsEntity.class).getResultList();
    }
}
