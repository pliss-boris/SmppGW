create table sms (
  id            varchar(32) PRIMARY KEY ,
  ext_id        varchar(32),
  owner_id      int,
  message_text  varchar(4096),
  data_coding   int
);


-- TLV20150101120101222+000000