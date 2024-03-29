DROP TABLE IF EXISTS TEAMS;
DROP TABLE IF EXISTS PLAYERS;

CREATE TABLE TEAMS(
  ID_TEAM INTEGER PRIMARY KEY NOT NULL,
  NAME_CATEGORY_PL VARCHAR(64) NOT NULL,
  NAME_CATEGORY_ENG VARCHAR(64) NOT NULL
);

CREATE TABLE PLAYERS(
  ID_PLAYER INTEGER PRIMARY KEY NOT NULL,
  NAME_PLAYER varchar(64) NOT NULL,
  SURNAME varchar(64) NOT NULL,
  POSITION VARCHAR(64) NOT NULL,
  DATE_OF_BIRTH DATE NOT NULL
);

CREATE TABLE PLAYER_OF_TEAM(
    ID INTEGER PRIMARY KEY NOT NULL
)

CREATE TABLE NEWS(
    ID_NEWS INTEGER PRIMARY KEY NOT NULL,
    TOPIC_NEWS VARCHAR(64) NOT NULL,
    TEXT VARCHAR(1250) NOT NULL,
    AUTHOR VARCHAR() NOT NULL,
    DATE_NEWS DATE NOT NULL
)
