-- Author: jurilens
-- Based on DB diagram:
-- https://lucid.app/lucidchart/invitations/accept/inv_5f745641-c3fc-48c0-8969-e151d0bc4fea?viewport_loc=25%2C37%2C1884%2C940%2C0_0
--
-- -------------------------------
-- | Database initialize script  |
-- -------------------------------


CREATE TABLE "Users"
(
    id                 INT       NOT NULL,
    "firstname"        VARCHAR(64),
    "secondname"       VARCHAR(64),
    "middlename"       VARCHAR(64),
    "email"            VARCHAR(64),
    "emailConfirmed"   BOOLEAN,
    "gender"           BOOLEAN,
    "birthday"         DATE,
    "registrationDate" TIMESTAMP NOT NULL DEFAULT NOW(),
    "passwordHash"     VARCHAR(128),

    PRIMARY KEY (id)
);

CREATE TABLE Roles
(
    id       SMALLINT    NOT NULL,
    "userId" INT         NOT NULL,
    "name"   VARCHAR(20) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT "FK_Roles_Users" FOREIGN KEY (userId) REFERENCES Users (id)
);


CREATE TABLE "Categories"
(
    id         INT         NOT NULL,
    "parentId" INT         NOT NULL,
    "name"     VARCHAR(48) NOT NULL,
    "position" INT,

    PRIMARY KEY (id),
    CONSTRAINT "FK_Categories_Categories" FOREIGN KEY (parentId) REFERENCES Categories (id)
);

CREATE TABLE "Templates"
(
    id              INT          NOT NULL,
    "categoryId"    INT          NOT NULL,
    "creatorUserId" INT          NOT NULL,
    "name"          VARCHAR(90)  NOT NULL,
    "sourceUrl"     VARCHAR(128) NOT NULL,
    "creationDate"  TIMESTAMP    NOT NULL DEFAULT NOW(),
    "rate"          SMALLINT,
    "isRecommended" BOOLEAN,

    PRIMARY KEY (id),
    CONSTRAINT "FK_Templates_Categories" FOREIGN KEY (categoryId) REFERENCES Categories (id),
    CONSTRAINT "FK_Templates_Users" FOREIGN KEY (creatorUserId) REFERENCES Users (id)
);

CREATE TABLE "Documents"
(
    id             INT          NOT NULL,
    "templateId"   INT          NOT NULL,
    "userId"       INT          NOT NULL,
    "creationDate" TIMESTAMP    NOT NULL DEFAULT NOW(),
    "resultUrl"    VARCHAR(128) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT "FK_Documents_Template" FOREIGN KEY (templateId) REFERENCES Templates (id),
    CONSTRAINT "FK_Documents_Users" FOREIGN KEY (userId) REFERENCES Users (id)
);

CREATE TABLE "FieldGroups"
(
    id           INT         NOT NULL,
    "templateId" INT         NOT NULL,
    "name"       VARCHAR(64) NOT NULL,
    "position"   INT,

    PRIMARY KEY (id),
    CONSTRAINT "FK_FieldGroups_Templates" FOREIGN KEY (templateId) REFERENCES Templates (id)
);

CREATE TABLE "FieldKeys"
(
    id           INT      NOT NULL,
    "groupId"    INT      NOT NULL,
    "templateId" INT      NOT NULL,
    "minLength"  INT,
    "maxLength"  INT,
    "isRequired" BOOLEAN  NOT NULL DEFAULT FALSE,
    "type"       SMALLINT NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT "FK_FieldKeys_FieldGroups" FOREIGN KEY (groupId) REFERENCES FieldGroups (id),
    CONSTRAINT "FK_FieldKeys_Templates" FOREIGN KEY (templateId) REFERENCES Templates (id)
);

CREATE TABLE "FiledValues"
(
    id        INT NOT NULL,
    "fieldId" INT NOT NULL,
    "docId"   INT NOT NULL,
    "value"   TEXT,

    PRIMARY KEY (id),
    CONSTRAINT "FK_FiledValues_FieldKeys" FOREIGN KEY (fieldId) REFERENCES FieldKeys (id),
    CONSTRAINT "FK_FiledValues_Documents" FOREIGN KEY (docId) REFERENCES Documents (id)
);
