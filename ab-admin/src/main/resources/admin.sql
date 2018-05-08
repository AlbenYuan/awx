CREATE TABLE IF NOT EXISTS `user` (
  id          VARCHAR(32) NOT NULL  DEFAULT '',
  username    VARCHAR(32)           DEFAULT ''
  COMMENT '用户登录账号',
  password    VARCHAR(255)          DEFAULT ''
  COMMENT '用户加密密码',
  salt        VARCHAR(16)           DEFAULT ''
  COMMENT '加密盐',
  name        VARCHAR(32)           DEFAULT ''
  COMMENT '用户姓名',
  email       VARCHAR(64)           DEFAULT ''
  COMMENT '用户邮箱',
  phone       VARCHAR(16)           DEFAULT ''
  COMMENT '用户手机号',
  login_id    VARCHAR(32)           DEFAULT ''
  COMMENT '最后登录ip',
  login_date  DATETIME              DEFAULT current_timestamp()
  COMMENT '最后登录ip',
  state       INT(2)                DEFAULT 0
  COMMENT '用户状态',
  deleted     BIT(1)                DEFAULT FALSE
  COMMENT '是否删除',
  create_date DATETIME              DEFAULT current_timestamp()
  COMMENT '创建时间',
  update_date DATETIME              DEFAULT current_timestamp() ON UPDATE current_timestamp()
  COMMENT '修改时间',
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS `user_role` (
  id          VARCHAR(32) DEFAULT '' NOT NULL,
  user_id     VARCHAR(32) DEFAULT '',
  role_id     VARCHAR(32) DEFAULT '',
  state       INT(2)      DEFAULT 0
  COMMENT '状态',
  deleted     BIT(1)      DEFAULT FALSE
  COMMENT '是否删除',
  create_date DATETIME    DEFAULT current_timestamp()
  COMMENT '创建时间',
  update_date DATETIME    DEFAULT current_timestamp() ON UPDATE current_timestamp()
  COMMENT '修改时间',
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS `role` (
  id          VARCHAR(32) NOT NULL  DEFAULT '',
  name        VARCHAR(32)           DEFAULT '',
  state       INT(2)                DEFAULT 0
  COMMENT '状态',
  deleted     BIT(1)                DEFAULT FALSE
  COMMENT '是否删除',
  create_date DATETIME              DEFAULT current_timestamp()
  COMMENT '创建时间',
  update_date DATETIME              DEFAULT current_timestamp() ON UPDATE current_timestamp()
  COMMENT '修改时间',
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS `menu` (
  id          VARCHAR(32) NOT NULL  DEFAULT '',
  parent_id   VARCHAR(32)           DEFAULT '',
  name        VARCHAR(32)           DEFAULT '',
  page        VARCHAR(255)          DEFAULT '',
  icon        VARCHAR(32)           DEFAULT '',
  show        BIT(1)                DEFAULT 1,
  state       INT(2)                DEFAULT 0
  COMMENT '状态',
  deleted     BIT(1)                DEFAULT FALSE
  COMMENT '是否删除',
  create_date DATETIME              DEFAULT current_timestamp()
  COMMENT '创建时间',
  update_date DATETIME              DEFAULT current_timestamp() ON UPDATE current_timestamp()
  COMMENT '修改时间',
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `operation` (
  id          VARCHAR(32) NOT NULL  DEFAULT '',
  name        VARCHAR(32)           DEFAULT '',
  action      VARCHAR(255)          DEFAULT ''
  COMMENT '操作标识',
  #   show        INT(1)                DEFAULT 0
  #   COMMENT '操作类型:0',
  state       INT(2)                DEFAULT 0
  COMMENT '状态',
  deleted     BIT(1)                DEFAULT FALSE
  COMMENT '是否删除',
  create_date DATETIME              DEFAULT current_timestamp()
  COMMENT '创建时间',
  update_date DATETIME              DEFAULT current_timestamp() ON UPDATE current_timestamp()
  COMMENT '修改时间',
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `role_operation` (
  id           VARCHAR(32)            NOT NULL,
  role_id      VARCHAR(32) DEFAULT '' NOT NULL,
  operation_id VARCHAR(32) DEFAULT '' NOT NULL,
  state        INT(2)   DEFAULT 0
  COMMENT '状态',
  deleted      BIT(1)   DEFAULT FALSE
  COMMENT '是否删除',
  create_date  DATETIME DEFAULT current_timestamp()
  COMMENT '创建时间',
  update_date  DATETIME DEFAULT current_timestamp() ON UPDATE current_timestamp()
  COMMENT '修改时间',
  PRIMARY KEY (id)
);





