-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--



CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)


CREATE TABLE ENCHERES(	
	no_article int NOT NULL,
	date_enchere datetime NOT NULL,
	montant_enchere int NOT NULL,
	no_utilisateur int NOT NULL
 )



CREATE TABLE RETRAITS (
	no_retrait       INTEGER IDENTITY(1,1) NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL
)

ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_retrait)  

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(50) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     varchar(256) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)

ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)


CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL,
	no_retrait					  INTEGER NULL
)



ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 


ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_retrait_fk FOREIGN KEY ( no_retrait )
        REFERENCES RETRAITS ( no_retrait )
ON DELETE no action 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ENCHERES ADD constraint enchere_pk PRIMARY KEY ( no_article)

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_no_article_fk FOREIGN KEY ( no_article ) REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 


INSERT Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values ('bobzob', 'bob', 'zob', 'bobzob@gmail.com', '0637279880', 'hkqsd', '35000', 'rennes', convert(varchar(256),HASHBYTES('SHA2_256','bobzob'),2) , 100, 0);
	
select * from UTILISATEURS where mot_de_passe = convert(varchar(256),HASHBYTES('SHA2_256','bobzob'),2);

select * from UTILISATEURS where (email = 'bobzob' OR pseudo = 'bobzob') and mot_de_passe = convert(varchar(256),HASHBYTES('SHA2_256','bobzob'),2);

select * from UTILISATEURS where 

select * from UTILISATEURS

SELECT UTILISATEURS WHERE email = ? OR pseudo = ?

select * from UTILISATEURS where email=''

select * from utilisateurs where mot_de_passe = convert(nvarchar(256),HASHBYTES('SHA2_256','test123'))

select mot_de_passe from UTILISATEURS where no_utilisateur = 3

UPDATE UTILISATEURS SET pseudo = 'bobzob', nom = 'ross', prenom = 'jqdhk', email = 'jkdqhd@test.com', telephone = '0637279880', rue = 'qshdkjqd', code_postal = '35000', ville = 'qhsdkqj', mot_de_passe = convert(nvarchar(256),HASHBYTES('SHA2_256', 'bobzob'),2) WHERE no_utilisateur = 1