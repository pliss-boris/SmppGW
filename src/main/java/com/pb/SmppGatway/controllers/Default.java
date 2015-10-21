package com.pb.SmppGatway.controllers;

import com.pb.SmppGatway.dao.mem.domain.SmsEntity;
import com.pb.SmppGatway.dao.mem.model.SmsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Boris on 9/18/2015.
 */
@Controller
public class Default {
    private static final Logger log = LoggerFactory.getLogger(Default.class);

    public class sms{
        private String id;
        private String externalId;
        private String message;
        private int owner;
        private int dataCoding;

        public sms() {
        }

        public sms(String id, String externalId, int owner, String message, int dataCoding) {
            this.id = id;
            this.externalId = externalId;
            this.message = message;
            this.owner = owner;
            this.dataCoding = dataCoding;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getExternalId() {
            return externalId;
        }

        public void setExternalId(String externalId) {
            this.externalId = externalId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getOwner() {
            return owner;
        }

        public void setOwner(int owner) {
            this.owner = owner;
        }

        public int getDataCoding() {
            return dataCoding;
        }

        public void setDataCoding(int dataCoding) {
            this.dataCoding = dataCoding;
        }
    }

    @Autowired
    private  SmsModel smsModel;



    @RequestMapping({"/", "/home"})
    public String getRoot(ModelMap model){
        List<SmsEntity> smsList = smsModel.getAll();
        model.addAttribute("list", smsList);

        return "index";
    }

}
