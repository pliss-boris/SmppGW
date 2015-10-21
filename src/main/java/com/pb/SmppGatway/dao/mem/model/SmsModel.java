package com.pb.SmppGatway.dao.mem.model;

import com.pb.SmppGatway.dao.mem.domain.SmsEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Boris on 10/19/2015.
 */
@Repository
@Transactional
public interface SmsModel {
    List<SmsEntity> getAll();

}
