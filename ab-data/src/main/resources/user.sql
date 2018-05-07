CREATE TABLE IF NOT EXISTS `user` (

  id             VARCHAR(32)  DEFAULT '' PRIMARY KEY,
  nickname       VARCHAR(32)  DEFAULT '',
  username       VARCHAR(32)  DEFAULT '',
  password       VARCHAR(64)  DEFAULT '',
  code           VARCHAR(8)   DEFAULT '',
  phone          VARCHAR(16)  DEFAULT '',
  phone_validate BIT(1)       DEFAULT FALSE,
  email          VARCHAR(32)  DEFAULT '',
  email_validate VARCHAR(32)  DEFAULT FALSE,
  state          INT(2)       DEFAULT 0,
  create_time    DATETIME     DEFAULT CURRENT_TIMESTAMP(),
  create_man     VARCHAR(32)  DEFAULT '',
  update_time    DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(),
  update_man     VARCHAR(32)  DEFAULT '',
  remark         VARCHAR(255) DEFAULT ''
);

CREATE TABLE IF NOT EXISTS `user_login` (
  id          VARCHAR(32)  DEFAULT '' PRIMARY KEY,
  user_id     VARCHAR(32)  DEFAULT ''
  COMMENT '用户的编号',
  login_state INT(2)       DEFAULT 0
  COMMENT '登录状态',
  login_ip    VARCHAR(32)  DEFAULT ''
  COMMENT '登录的ip',
  login_type  VARCHAR(32)  DEFAULT ''
  COMMENT '登录的设备',
  state       INT(2)       DEFAULT 0,
  create_time DATETIME     DEFAULT CURRENT_TIMESTAMP(),
  create_man  VARCHAR(32)  DEFAULT '',
  update_time DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(),
  update_man  VARCHAR(32)  DEFAULT '',
  remark      VARCHAR(255) DEFAULT ''
);