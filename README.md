-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP TYPE Attachement;

CREATE TYPE Attachement AS (
	id bigserial,
	"name" varchar(255),
	"path" varchar(255),
	"size" varchar(255),
	"type" varchar(255));

-- DROP TYPE AttachementReclamation;

CREATE TYPE AttachementReclamation AS (
	id bigserial,
	nc varchar(255),
	"ref" varchar(2550),
	sf varchar(255),
	"name" varchar(255),
	"path" varchar(255),
	"size" varchar(255),
	"type" varchar(255),
	dateoperation varchar(255),
	datevaleur varchar(255),
	libelleoperation varchar(255),
	montant varchar(255));

-- DROP TYPE Chat;

CREATE TYPE Chat AS (
	chat_id bigserial,
	"name" varchar(255));

-- DROP TYPE Chat_messages;

CREATE TYPE Chat_messages AS (
	"Chat_chat_id" int8,
	messages_id int8);

-- DROP TYPE Chat_users;

CREATE TYPE Chat_users AS (
	"Chat_chat_id" int8,
	users_id int8);

-- DROP TYPE Classification;

CREATE TYPE Classification AS (
	id bigserial,
	classe int4,
	commentaire varchar(255),
	decision varchar(255),
	motif varchar(255),
	client_account varchar(255));

-- DROP TYPE Classification_attachements;

CREATE TYPE Classification_attachements AS (
	"Classification_id" int8,
	attachements_id int8);

-- DROP TYPE Client;

CREATE TYPE Client AS (
	account varchar(255),
	code varchar(255),
	profile varchar(255),
	username varchar(255));

-- DROP TYPE Composant;

CREATE TYPE Composant AS (
	id bigserial,
	description varchar(8000),
	query varchar(255),
	title varchar(255),
	createdby varchar(255),
	"timestamp" timestamp);

-- DROP TYPE DownloadPin;

CREATE TYPE DownloadPin AS (
	id bigserial,
	createdat timestamp,
	isvalidated bool,
	pin varchar(255),
	user_id int8);

-- DROP TYPE E_ACCOUNT;

CREATE TYPE E_ACCOUNT AS (
	"CDRCONTMUTL" int4,
	"ID" varchar,
	"CUST" varchar,
	"CATG" varchar,
	"ACCN_TITL_1" varchar,
	"ACCN_TITL_2" varchar,
	"SHRT_TITL" varchar,
	"MNMN" varchar,
	"CURR" varchar,
	"LIMT_REF" varchar,
	"ACCN_OFFC" varchar,
	"POST_REST" varchar,
	"INTR_COMP_ACCT" varchar,
	"COND_GRP" varchar,
	"INCT_MARK" varchar,
	"OPNN_DATE" int4,
	"LINK_TO_LIMIT" varchar,
	"CLSR_DATE" int4,
	"CHRG_CCY" varchar,
	"CHRG_MKT" varchar,
	"INTR_CCY" varchar,
	"INTR_MKT" varchar,
	"ALL_NETT" varchar,
	"SING_LIMIT" varchar,
	"CLSD_ONLN" varchar,
	"CO_CODE" varchar,
	"RIB" varchar,
	"Comp_CTOS" varchar,
	"AUTR_MOTF_OUV" varchar,
	"CART_EPRG" varchar,
	"CU_AUTR_REST" varchar,
	"EMP_DEMR" varchar,
	"FORW_MVMT" varchar,
	"INT_LIQ_CCY" varchar,
	"INT_LIQU_ACCT" varchar,
	"MOTF_OUVR" varchar,
	"NATR_COMP" varchar,
	"NUM_LIVR" varchar,
	"OPT_SIGN" varchar,
	"OPTN_COMP" varchar,
	"OTHR_OFFC" varchar,
	"ACCT_CLSE_DATE" int4,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_ACCOUNT_PERSO_BIAT;

CREATE TYPE E_ACCOUNT_PERSO_BIAT AS (
	"CDRCONTRH" int4,
	"ID" varchar,
	"CUST" varchar,
	"CATG" varchar,
	"ACCN_TITL_1" varchar,
	"ACCN_TITL_2" varchar,
	"SHRT_TITL" varchar,
	"MNMN" varchar,
	"CURR" varchar,
	"LIMT_REF" varchar,
	"ACCN_OFFC" varchar,
	"POST_REST" int4,
	"INTR_COMP_ACCT" varchar,
	"COND_GRP" varchar,
	"INCT_MARK" varchar,
	"OPNN_DATE" varchar,
	"LINK_TO_LIMIT" varchar,
	"CLSR_DATE" varchar,
	"CHRG_CCY" varchar,
	"CHRG_MKT" varchar,
	"INTR_CCY" varchar,
	"INTR_MKT" varchar,
	"ALLW_NETT" varchar,
	"SING_LIMIT" varchar,
	"CLSD_ONLN" varchar,
	"CO_CODE" varchar,
	"RIB" varchar,
	"Comp_CTOS" varchar,
	"AUTR_MOTF_OUV" varchar,
	"CART_EPRG" varchar,
	"CU_AUTR_REST" int4,
	"EMP_DEMR" varchar,
	"FORW_MVMT" varchar,
	"INT_LIQ_CCY" varchar,
	"INT_LIQU_ACCT" varchar,
	"MOTF_OUVR" varchar,
	"NATR_COMP" varchar,
	"NUM_LIVR" varchar,
	"OPT_SIGN" varchar,
	"OPTN_COMP" varchar,
	"OTHR_OFFC" varchar,
	"ACCT_CLSE_DATE" int4,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_ACCOUNT_SOLDE;

CREATE TYPE E_ACCOUNT_SOLDE AS (
	"CDRCONTMUTL" int4,
	"ID" varchar(19),
	"ACCR_CHG_AMNT" varchar(19),
	"ACCR_CHG_CATG" varchar(6),
	"ACCR_CR_AMNT" varchar(19),
	"ACCR_CR_CATG" varchar(6),
	"ACCR_DR_AMNT" varchar(19),
	"ACCR_DR_CATG" varchar(6),
	"OPEN_ACTL_BAL" varchar(19),
	"OPEN_CLRD_BAL" varchar(19),
	"ONLN_ACTL_BAL" varchar(19),
	"ONLN_CLRD_BAL" varchar(19),
	"WORK_BALN" varchar(19),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_ACCOUNT_SOLDE_PERSO_BIAT;

CREATE TYPE E_ACCOUNT_SOLDE_PERSO_BIAT AS (
	"CDRCONTRH" int4,
	"ID" varchar(19),
	"ACCR_CHG_AMNT" varchar(19),
	"ACCR_CHG_CATG" varchar(19),
	"ACCR_CR_AMNT" varchar(19),
	"ACCR_CR_CATG" varchar(19),
	"ACCR_DR_AMNT" varchar(19),
	"ACCR_DR_CATG" varchar(19),
	"OPEN_ACTUAL_BAL" varchar(19),
	"OPEN_CLEARED_BAL" varchar(19),
	"ONLINE_ACTUAL_BAL" varchar(19),
	"ONLINE_CLEARED_BAL" varchar(19),
	"WORKING_BALANCE" varchar(19),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_CONTRAT;

CREATE TYPE E_CONTRAT AS (
	"CDRCONTMUTL" int4,
	"REF_CONT" varchar,
	"REF_CRDT" varchar,
	"CUST" varchar,
	"CURR" varchar,
	"CATG" varchar,
	"CONT_DATE" varchar,
	"VAL_DATE" varchar,
	"MATR_DATE" varchar,
	"LIMT_REF" varchar,
	"COMP" varchar,
	"ACCT_OFFC" varchar,
	"INTR_KEY" varchar,
	"TIEG" varchar,
	"INTR_SPREAD" varchar,
	"TAUX_BASE" varchar,
	"MARG" varchar,
	"INTR_RATE" varchar,
	"TYPE_ENG" varchar,
	"REF_TITR_CR" varchar,
	"MONT_DEBL" varchar,
	"CDRCUST" int4,
	"CDRCODENG" int4,
	"CDRCURR" int4,
	"CDR_TITR" int4,
	"CDRCATG" int4,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_CONTRAT_PERSO_BIAT;

CREATE TYPE E_CONTRAT_PERSO_BIAT AS (
	"CDRCONTRH" int4,
	"REF_CONT" varchar(20),
	"CODE_ENGG" varchar(10),
	"COMP_CTOS" varchar(10),
	"PRSN_NOM" varchar(100),
	"DATE_DEBL" int4,
	"MONT_DEBL" float4,
	"MNT_PPL_ECH" float4,
	"MNT_INT_ECH" float4,
	"DATE_DEBT_REMB" int4,
	"MATR_DATE" int4,
	"TAUX_INTR" float4,
	"TAUX_INTR_WR" float4,
	"INTR_BASS" varchar(3),
	"RANG_CREDT" int4,
	"NBRE" int4,
	"REF_TITR_CR" varchar(20),
	"COMP" varchar,
	"CODE_CLNT" varchar,
	"MATR" varchar,
	"LIMT_REF" varchar,
	"CURR" varchar,
	"CATG" varchar,
	"CDRCUST" int4,
	"CDRCODENGRH" int4,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DAT_CHG" int4);

-- DROP TYPE E_CURRENCY;

CREATE TYPE E_CURRENCY AS (
	"CDR_CURR" int4,
	"ID" varchar(100),
	"RANK" int4,
	"NUMR_CCY_CODE" int4,
	"INTR_DAY_BASS" varchar(100),
	"CONT_CODE" varchar(100),
	"REVL_RATE" varchar(16),
	"UNTE" varchar(4),
	"DESC" varchar(100),
	"DATDEBVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4,
	"DATFINVLD" int4);

-- DROP TYPE E_CUSTOMER;

CREATE TYPE E_CUSTOMER AS (
	"CDRCUST" int4,
	"DATDEBVLD" int4,
	"ACCN_OFFC" varchar(255),
	"AGRM" varchar(255),
	"ANNL_BONS" varchar(255),
	"BIRT_INCR_DATE" varchar(255),
	"CART_SEJR" varchar(255),
	"CDRACTV" int4,
	"CDRBIATPRFS" int4,
	"CDRINDS" int4,
	"CDRTARG" int4,
	"CIN" varchar(255),
	"CONT" varchar(255),
	"CONT_DATE" varchar(255),
	"CUST_CURR" varchar(255),
	"CUST_LIBL" varchar(255),
	"CUST_STTS" int4,
	"CUST_TYPE" varchar(255),
	"CU_ACTV" varchar(255),
	"CU_ANNE_CA" varchar(255),
	"CU_BLCK_LIST" varchar(255),
	"CU_CAPC_JUR" varchar(255),
	"CU_CAPT_SOCL" varchar(255),
	"CU_CHFF_AFFR" float4,
	"CU_CODE_BCT" varchar(255),
	"CU_CODE_SIT_JUR" int4,
	"CU_DATE_SIT_JUR" int4,
	"CU_DT_INTR_CHE" varchar(255),
	"CU_DT_TRAN_CNTX" int4,
	"CU_FORM_JUR" int4,
	"CU_GROP_AFFR" varchar(255),
	"CU_INTR_CART" varchar(255),
	"CU_INTR_CHQ" varchar(255),
	"CU_NB_EMPL" varchar(255),
	"CU_POLE_GEST" varchar(255),
	"CU_PRFS" varchar(255),
	"CU_PRSP_TRE" varchar(255),
	"CU_QULT" varchar(255),
	"CU_TYPE_ADRS" varchar(255),
	"DATCHG" int4,
	"DATE_AUT_BCT" int4,
	"DATE_EXPR_PASS" varchar(255),
	"DATE_OF_BIRTH" varchar(255),
	"DATFINVLD" int4,
	"DERSIT" int4,
	"EMAL_1" varchar(255),
	"EMPL_STTS" varchar(255),
	"EXNR_TVA" varchar(255),
	"FAMILY_NAME" varchar(255),
	"GEND" varchar(255),
	"GIVEN_NAMES" varchar(255),
	"ID" varchar(255),
	"IDNT_FISC" varchar(255),
	"IDNT_UNQ" varchar(255),
	"ID_BCT" varchar(255),
	"INDS" int4,
	"ISSU_CHQU" varchar(255),
	"JOB_TITL" varchar(255),
	"LANG" int4,
	"LEGL_EXP_DATE" int4,
	"MANL_RISK_CLSS" varchar(255),
	"MART_STTS" varchar(255),
	"MATR_FISC" varchar(255),
	"MNMN" varchar(255),
	"NAME_1" varchar(255),
	"NATN" varchar(255),
	"NET_MONT_IN" varchar(255),
	"NET_MONT_OUT" varchar(255),
	"NUMR_ANLT_CODE_PTT_GRFF" varchar(255),
	"NUM_BCT" varchar(255),
	"OTHR_NATN" varchar(255),
	"OTHR_OFFC" varchar(255),
	"OVRR_RESN" varchar(255),
	"PASS" varchar(255),
	"PATN" varchar(255),
	"PHNE_1" varchar(255),
	"POST_CODE" varchar(255),
	"POST_REST" int4,
	"RESD" varchar(255),
	"SALR" varchar(255),
	"SECT" varchar(255),
	"SHORT_NAME" varchar(255),
	"SMS_1" varchar(255),
	"SRC" varchar(255),
	"STRT" varchar(255),
	"TARG" int4,
	"TITL" varchar(255),
	"TOWN_CONT" varchar(255),
	"TYPE_ID_BCT" varchar(255),
	"VISA" varchar(255));

-- DROP TYPE E_CUSTOMER_RELATION;

CREATE TYPE E_CUSTOMER_RELATION AS (
	"CDRCUST" int4,
	"CDRRELTCUST" int4,
	"ID" varchar(10),
	"RELT_CUST" varchar(10),
	"RELT_CODE" int4,
	"REVR_REL_CODE" varchar(3),
	"CDRRELT" int4,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_DRAWINGS;

CREATE TYPE E_DRAWINGS AS (
	"CDRCONTMUTL" int4,
	"ID" varchar(200),
	"DRWN_TYPE" varchar(200),
	"DRW_CURR" varchar(200),
	"DOCM_AMNT" float8,
	"VALU_DATE" int4,
	"DRWD_ACCNT" varchar(200),
	"PAMN_METH" varchar(200),
	"PAMN_ACCNT" varchar(200),
	"PAMN_AMNT" float8,
	"REMB_AMNT" float8,
	"LIMT_REFR" varchar(200),
	"DOC_AMT_LOCL" float8,
	"DOC_AMT_LC_CCY" float8,
	"FULL_UTLS" varchar(200),
	"LC_CRDT_TYPE" varchar(200),
	"CUST_LINK" varchar(200),
	"PROV_AMT_REL" varchar(19),
	"LC_LIAB_RELS" float8,
	"LC_LIAB_REL_LCY" float8,
	"REMB_AMT_LCCY" float8,
	"PAY_AMT_LCCY" float8,
	"PROV_REL_LC_CCY" float8,
	"PROV_REL_DOC_CCY" float8,
	"MATR_REVW" int4,
	"CHRG_CODE" varchar(200),
	"CHRG_CURR" varchar(200),
	"CHRG_AMNT" varchar(200),
	"RELTED_DRWN" varchar(200),
	"CHRG_LCCY_AMT" varchar(200),
	"TYP_ENG" varchar(200),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_ENCOURS;

CREATE TYPE E_ENCOURS AS (
	"CDRCONTMUTL" int4,
	"REF_CONT" varchar(15),
	"MONT_ENCR_INTL_TND" numeric(15,3),
	"MONT_ENCR_REDR_TND" numeric(15,3),
	"MONT_ENCR_INTL_DEV" numeric(15,3),
	"MONT_ENCR_REDR_DEV" numeric(15,3),
	"CODE_TYP_ENCR" int4,
	"STATUT" bpchar(1),
	"CDR_TYP_ENCR" int4,
	"DAT_SIT" int4,
	"DERSIT" int4,
	"DAT_CHG" varchar(20));

-- DROP TYPE E_ENCOURS_PERSO_BIAT;

CREATE TYPE E_ENCOURS_PERSO_BIAT AS (
	"CDRCONTRH" int4,
	"REF_CONT" varchar(15),
	"MONT_ENCR_INTL" numeric(15,3),
	"MONT_ENCR" numeric(15,3),
	"MONT_ENCR_TND" numeric(15,3),
	"CODE_TYP_ENCR" int4,
	"STATUT" varchar(1),
	"DAT_SIT" int4,
	"DERSIT" int4,
	"DAT_CHG" varchar(20),
	cdrcontmutl int4);

-- DROP TYPE E_LC;

CREATE TYPE E_LC AS (
	"CDRCONTMUTL" int4,
	"ID" varchar,
	"CUST" varchar,
	"CURR" varchar,
	"ACCN" varchar,
	"TYPE_ENG" varchar,
	"ISSU_DATE" int4,
	"EXPR_DATE" int4,
	"OPRT" varchar,
	"LC_TYPE" varchar,
	"EXTR_REFR" varchar,
	"CHRG_ACCN" varchar,
	"LC_AMNT" float8,
	"DAY_BASS" varchar,
	"CURR_MARK" varchar,
	"POST_TYPE" varchar,
	"LIMT_REFR" varchar,
	"EXPR_PLAC" varchar,
	"CLSN_DATE" int4,
	"BENF_CUST" varchar,
	"CATG_CODE" varchar,
	"ACCN_OFFC" varchar,
	"LIBL_AMT" float8,
	"LC_AMNT_LOCL" float8,
	"DRWN" float8,
	"NEXT_DRWN" varchar,
	"PAMN_AMT" float8,
	"APPL_CUST" varchar,
	"APPL_ACC" varchar,
	"FULLY_UTLS" varchar,
	"PRVS_PERC" varchar,
	"PRVS_AMNT" float8,
	"PRO_OUT_AMNT" float8,
	"PRO_AWAT_REL" float8,
	"PRVS_RATE" float8,
	"BENF" varchar,
	"DRAW_TYPE" varchar,
	"LIAB_PORT_AMT" float8,
	"LCY_PORT_AMT" float8,
	"LR_EFF_AVAL" varchar,
	"LR_REF_AVAL" varchar,
	"NUMR_COMP" varchar,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_LD;

CREATE TYPE E_LD AS (
	"CDRCONTMUTL" int4,
	"ID" varchar(200),
	"CUST_ID" varchar(200),
	"CURR" varchar(200),
	"VALU_DATE" int4,
	"FIN_MAT_DATE" int4,
	"LIMT_REFR" varchar(200),
	"CATG" varchar(200),
	"DRWD_ACCN" varchar(200),
	"INT_RATE_TYPE" varchar(200),
	"INTR_BASI" varchar(200),
	"INT_PAMT_METH" varchar(200),
	"INTR_KEY" varchar(200),
	"INTR_SPRD" float4,
	"ACCR_PARM" varchar(200),
	"LIQU_MODE" varchar(200),
	"OVRD_STTS" varchar(200),
	"GRAC_PERD" varchar(200),
	"GRAC_AMNT" varchar(200),
	"PRIN_LIQ_ACCT" varchar(200),
	"INT_LIQ_ACCT" varchar(200),
	"CHRG_LIQ_ACCT" varchar(200),
	"MIS_ACCT_OFFC" varchar(200),
	"AGRM_DATE" int4,
	"CONR_RISK" varchar(200),
	"CONT_EXPS" varchar(200),
	"STTS" varchar(200),
	"DRWD_ISSU_PRC" float4,
	"DRWD_NET_AMT" float4,
	"REMB_AMNT" float4,
	"FEE_PAY_ACCNT" varchar(200),
	"AMNT_INCR" varchar(200),
	"NEW_SPRD" varchar(200),
	"SPRD_V_DATE" varchar(200),
	"DRWD_ENT_DATE" int4,
	"CO_CODE" varchar(200),
	"A_PRRG" varchar(35),
	"A_RENV" varchar(15),
	"BANQ_TIRE" varchar(10),
	"BILL_NUMB" varchar(12),
	"CHRG_AMNT" varchar(10),
	"CHRG_BOKD_ON" int4,
	"CHRG_CPTL" varchar(35),
	"CHRG_CLM_DATE" int4,
	"CHRG_CODE" varchar(3),
	"CLE_TAUX_BASE" int4,
	"CONT_MARC" varchar(18),
	"DURE_CRDT" float4,
	"ENCR_INTL" float4,
	"INTR_RATE" float4,
	"LD_INTR_NET" float4,
	"LD_MARG" float4,
	"LD_MARG_INIT" float4,
	"LD_NANT" varchar(35),
	"LIB_TYPE_ENG" varchar(100),
	"MARG" float4,
	"NIV_DELG_MAX" varchar(35),
	"NOM_TIRE" varchar(100),
	"OUR_REMR" varchar(35),
	"REF_MARC" varchar(15),
	"REF_TITR_CRDT" varchar(35),
	"RIB_TIRE" varchar(35),
	"TAUX_BASE" float4,
	"TAUX_GLBL" float4,
	"TIEG" float4,
	"TIEX" float4,
	"TITR" varchar(35),
	"TYPE_CRDT" varchar(35),
	"TYPE_ENG" varchar(35),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_MD;

CREATE TYPE E_MD AS (
	"CDRCONTMUTL" int4,
	"ID" varchar(17),
	"CURR" varchar(3),
	"CUST" varchar(10),
	"TYP_ENG" varchar(35),
	"ACCN" varchar(35),
	"VALU_DATE" varchar(11),
	"MATR_DATE" varchar(11),
	"EPS_MONT_INI" varchar,
	"CCY_MARK" varchar,
	"PRNC_AMNT" varchar,
	"DEAL_DATE" varchar,
	"CONT_TYPE" varchar,
	"DEAL_SUB_TYPE" varchar,
	"CATG" varchar,
	"LIMT_UPD_REQD" varchar,
	"LIMT_REFR" varchar,
	"ACCN_OFFC" varchar,
	"CONT_RISK" varchar,
	"CONT_EXPS" varchar,
	"LIMT_AMNT" varchar,
	"STTS" varchar,
	"NET_PRIN_AMNT" varchar,
	"INCL_PRVS" varchar,
	"PRVS" varchar,
	"PROV_DR_ACCNT" varchar,
	"PROV_PERC" varchar,
	"PROV_AMNT" varchar,
	"PROV_REL_DATE" int4,
	"PROV_REL_ACCN" varchar,
	"AUTO_EXPR" varchar,
	"ALTR_ID" varchar,
	"LIQD_MODE" varchar,
	"CHRG_DATE" varchar,
	"CHRG_CURR" varchar,
	"CHRG_ACCN" varchar,
	"TAX_CODE" varchar,
	"BEN_ADDR" varchar,
	"EPS_REF_MARC" varchar,
	"EPS_MOTF_APUR" varchar,
	"EPS_MODF" varchar,
	"EPS_ECH_INTL" int4,
	"EPS_TYPE_DOC" varchar,
	"EPS_DELV" varchar,
	"EPS_AVIS_MJEU" varchar,
	"EPS_CAUT_MODL" varchar,
	"EPS_RECP" varchar,
	"EPS_DELV_REMP" varchar,
	"EPS_DT_RECP_MJ" int4,
	"EPS_PIST_CMC7" varchar,
	"EPS_MONTN_EFF" varchar,
	"EPS_ECH_EFFT" int4,
	"EPS_RIB_DEST" varchar,
	"EPS_PAMN_MJ" varchar,
	"EPS_DEST" varchar,
	"EPS_DT_REMS_C" int4,
	"EPS_NBJR_VALI" int4,
	"EPS_PORC_CD" int4,
	"EPS_MOTF_ANNL" varchar,
	"EPS_CONT_MAR" varchar,
	"EPS_ACCN" varchar,
	"MIGR" varchar,
	"NIV_DELG_MAX" varchar,
	"EPS_VALD" varchar,
	"EPS_MODL" varchar,
	"EPS_APR_PART" varchar,
	"EPS_APR_ECH_AUT" varchar,
	"EPS_MOIS_INDV" varchar,
	"LIB_TYPE_ENG" varchar,
	"EPS_TEMP_INV" float8,
	"EPS_TEMP_PROV" float8,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_MG;

CREATE TYPE E_MG AS (
	"CDRCONTMUTL" int4,
	"ID" varchar,
	"CUST" varchar,
	"CONT_TYP" varchar,
	"CONT_STTS" varchar,
	"CURR" varchar,
	"PRNC_AMNT" float8,
	"CATG" varchar,
	"CONT_DATE" int4,
	"VAL_DATE" int4,
	"TERM" float4,
	"ORGN_MAT_DATE" int4,
	"MATR_DATE" int4,
	"INTR_BASS" varchar,
	"EFFC_INT" varchar,
	"REPM_DATE" varchar(19),
	"REDM_DATE" varchar,
	"REDM_STRT_DATE" int4,
	"REPM_AMNT" float8,
	"THRT_AMNT" float8,
	"LIQU_MODE" varchar,
	"OVRD_STTS" varchar,
	"LIMT_REF" varchar,
	"MORT_ACCN" varchar,
	"DRWD_ACCN" varchar,
	"TOTL_CHRG" float8,
	"TOTL_CHG_TAX" float8,
	"MIS_ACCT_OFFC" varchar,
	"INTL_RATE" float8,
	"INT_LIQ_ACCT" varchar,
	"CO_CODE" varchar,
	"MG_TIEX" float8,
	"INTR_KEY" varchar,
	"MG_REF_CONV" varchar,
	"PAMN_TYPE" varchar,
	"FIXD_VAR_IND" varchar,
	"MG_TIEG" float8,
	"MG_REF_VERS" varchar,
	"DETL_BESN" varchar,
	"NIV_DELG_MAX" varchar,
	"MG_REF_DEMN" varchar,
	"MG_REF_BESN" varchar,
	"OUR_REMR" varchar,
	"TYPE_CREDT" varchar,
	"INTR_SPRD" float8,
	"MG_TAUX_BASE" float8,
	"MG_MARG" float4,
	"CHRG_TAX_LCY" varchar,
	"CHRG_CODE" varchar,
	"CHRG_DATE" varchar,
	"INTR_RATE" float8,
	"CHRG_CCY" varchar,
	"CHRG_AMNT" varchar,
	"CHRG_ACCN" varchar,
	"TYPE_ENG" varchar,
	"MG_REF_TITR_CR" varchar,
	"CHRG_AMT_LCY" varchar,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_PD;

CREATE TYPE E_PD AS (
	"CDRCONTMUTL" int4,
	"ID" varchar,
	"CUSTOMER" varchar,
	"CURRENCY" varchar,
	"CURRENCY_MARKET" varchar,
	"POSITION_TYPE" varchar,
	"ACCOUNT_OFFICER" varchar,
	"CATEGORY" varchar,
	"INTEREST_BASIS" varchar,
	"PENALTY_RATE" varchar,
	"PENALTY_KEY" varchar,
	"PENALTY_SPREAD" varchar,
	"PARAMETER_RECORD" varchar,
	"ORIG_LIMIT_REF" varchar,
	"LIMIT_REFERENCE" varchar,
	"FINAL_DUE_DATE" varchar,
	"REPAYMENT_ACCT" varchar,
	"START_DATE" varchar,
	"CO_CODE" varchar,
	"ACCRUAL_PARAM" varchar,
	"ROUNDING_RULE" varchar,
	"WAIVE_GRA_PE" varchar,
	"WAIVE_GRA_PS" varchar,
	"ORIG_STLMNT_ACT" varchar,
	"REPAID_STATUS" varchar,
	"TYPE_CREDIT" varchar,
	"TYPE_ENG" varchar,
	"LIB_TYPE_ENG" varchar,
	"PRIORITE_IMPAYE" varchar,
	"INTERVALLE_IMP" varchar,
	"ENV_RECOUV_EXT" varchar,
	"TYPE_RECOUV_EXT" varchar,
	"RS_RECOUV_EXT" varchar,
	"DOC_RECOUV_EXT" varchar,
	"NAT_DOC_RECOUV" varchar,
	"REFERENCE" varchar,
	"COMPTE" varchar,
	"COURS_CHANGE" varchar,
	"LC_NUMBER_12" varchar,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_PD_DETAIL;

CREATE TYPE E_PD_DETAIL AS (
	"CDRCONTMUTL" int4,
	"ID" varchar(35),
	"DAT_ECHN" varchar(8),
	"REF_CONT" varchar(14),
	"ANCN" varchar(8),
	"MONT_PRNC_INTL" varchar(30),
	"MONT_PRNC_INTL_RED" varchar(30),
	"MONT_PRNC_INTL_TND" varchar(30),
	"MONT_PRNC_ACTL" varchar(30),
	"MONT_PRNC_ACTL_RED" varchar(30),
	"MONT_PRNC_ACTL_TND" varchar(30),
	"MONT_INTR_INTL" varchar(30),
	"MONT_INTR_INTL_RED" varchar(30),
	"MONT_INTR_INTL_TND" varchar(30),
	"MONT_INTR_ACTL" varchar(30),
	"MONT_INTR_ACTL_RED" varchar(30),
	"MONT_INTR_ACTL_TND" varchar(30),
	"MONT_INTR_RETR_1_INTL" varchar(30),
	"MONT_INTR_RETR_1_INTL_RED" varchar(30),
	"MONT_INTR_RETR_1_INTL_TND" varchar(30),
	"MONT_INTR_RETR_1_ACTL" varchar(30),
	"MONT_INTR_RETR_1_ACTL_RED" varchar(30),
	"MONT_INTR_RETR_1_ACTL_TND" varchar(30),
	"MONT_INTR_RETR_2_INTL" varchar(30),
	"MONT_INTR_RETR_2_INTL_RED" varchar(30),
	"MONT_INTR_RETR_2_INTL_TND" varchar(30),
	"MONT_INTR_RETR_2_ACTL" varchar(30),
	"MONT_INTR_RETR_2_ACTL_RED" varchar(30),
	"MONT_INTR_RETR_2_ACTL_TND" varchar(30),
	"MONT_WS_INTL" varchar(30),
	"MONT_WS_INTL_RED" varchar(30),
	"MONT_WS_INTL_TND" varchar(30),
	"MONT_WS_ACTL" varchar(30),
	"MONT_WS_ACTL_RED" varchar(30),
	"MONT_WS_ACTL_TND" varchar(30),
	"MONT_WE_INTL" varchar(30),
	"MONT_WE_INTL_RED" varchar(30),
	"MONT_WE_INTL_TND" varchar(30),
	"MONT_WE_ACTL" varchar(30),
	"MONT_WE_ACTL_RED" varchar(30),
	"MONT_WE_ACTL_TND" varchar(30),
	"DAT_SIT" int4,
	"DERSIT" int4,
	"DATCHG" varchar(20));

-- DROP TYPE E_PD_MONTANT;

CREATE TYPE E_PD_MONTANT AS (
	"CDRCONTMUTL" int4,
	"ID" varchar,
	"TOTAL_AMT_TO_REPAY" varchar,
	"ANCIENNETE_IMP" varchar,
	"INTERET" varchar,
	"PRINCIPAL" varchar,
	"PENALITE_RETARD_PS" varchar,
	"PENALITE_RETARD_WE" varchar,
	"PENALITE_RETARD_WS" varchar,
	"PENALITE_RETARD_PE" varchar,
	"MONTANT" varchar,
	"DAT_SIT" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_TITRE_CREDIT;

CREATE TYPE E_TITRE_CREDIT AS (
	"CDR_TITR" int4,
	"REF_TITRE" varchar(200),
	"REF_CREDIT" varchar(200),
	"DATE_GENR" varchar(200),
	"ORDRE_TRNC" varchar(200),
	"CODE_CLNT" varchar(200),
	"COM_CLNT" varchar(200),
	"ADRS_CLNT" varchar(200),
	"DOMC_BANC" varchar(200),
	"COMP_CLNT" varchar(200),
	"CPTE_CLT_CTOS" varchar(200),
	"RIB_CLNT" varchar(200),
	"CATG" varchar(200),
	"TYP_CRDT" varchar(200),
	"TYP_INTR" varchar(200),
	"DUREE" varchar(200),
	"DAT_SOSC" varchar(200),
	"LIEU_SOSC" varchar(200),
	"TAUX_CMP" varchar(200),
	"MONT_CMP" varchar(200),
	"TAUX_CETD" varchar(200),
	"MONT_CETD" varchar(200),
	"TAUX_COM_ENG" varchar(200),
	"TAUX_CONT_FNG" varchar(200),
	"TAUX_SOTUGAR" varchar(200),
	"MONT_DEBL" varchar(200),
	"TAUX_BASE" varchar(200),
	"MARG" varchar(200),
	"TAUX_APPL" varchar(200),
	"TIEG" varchar(200),
	"TAUX_CPG" varchar(200),
	"TAUX_CG" varchar(200),
	"MNT_TOT_INT" varchar(200),
	"TYPE_REMB" varchar(200),
	"DAT_DEBLC_THQ" varchar(200),
	"DAT_DEBLC_EFF" varchar(200),
	"DAT_SIGN_CNTR" varchar(200),
	"DAT_P_ECH_INT" varchar(200),
	"DAT_P_ECH_PPL" varchar(200),
	"PERDCT_PPL" varchar(200),
	"PERDCT_INT" varchar(200),
	"ANNTE" varchar(200),
	"NB_ECHN" varchar(200),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_TITRE_CREDIT_ECHEANCIER;

CREATE TYPE E_TITRE_CREDIT_ECHEANCIER AS (
	"CDR_TITR" int4,
	"REF_TITR" varchar(20),
	"NUM_ECHN" int4,
	"DATE_ECH" int4,
	"NB_JOURS_ECH" int4,
	"ENCR_ECH" numeric(15,3),
	"REF_CTOS_PPL" varchar(15),
	"MNT_PPL_ECH" numeric(15,3),
	"REF_CTOS_INT" varchar(15),
	"MNT_INT_ECH" numeric(15,3),
	"MNT_INT_COM_ECH" numeric(15,3),
	"MNT_TOT_ECH" numeric(15,3),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE E_TITRE_CREDIT_ECHEANCIER_temp;

CREATE TYPE E_TITRE_CREDIT_ECHEANCIER_temp AS (
	"ID" varchar,
	"BLOC" varchar,
	"CHAMP" varchar,
	"VALEUR" varchar,
	"DAT_SIT" int4,
	"DAT_CHG" int4,
	"DAT_CSO" int4);

-- DROP TYPE Functions;

CREATE TYPE Functions AS (
	id bigserial,
	"name" varchar(255),
	query varchar(255),
	queryexcel varchar(255),
	status int4,
	creator varchar(255));

-- DROP TYPE History;

CREATE TYPE History AS (
	id bigserial,
	actiontext varchar(255),
	actiontime timestamp,
	actiontype varchar(255));

-- DROP TYPE LST;

CREATE TYPE LST AS (
	periode varchar(255),
	unite varchar(255),
	eng_global float8,
	eng_ctx float8,
	eng_lease float8,
	mnt_rb_inf_20m float8,
	mnt_rb_inf_500 float8,
	pme_eng float8,
	prf_eng float8,
	par_eng float8,
	total_imp float8,
	mnt_imp_sup_90 float8,
	cre_rat_sup_90 float8,
	renov_eng float8,
	renov_imp float8,
	media_eng float8,
	media_imp float8,
	auto_eng float8,
	auto_imp float8,
	eng_par_hors_immo float8,
	imp_par_hors_immo float8,
	habitat_eng float8,
	habitat_imp float8,
	imp_prc float8,
	non_aut float8,
	dep float8,
	echu float8,
	cdl_nbr float8,
	cdl_mnt float8,
	cdl_inf_20m_nbr float8,
	cdl_inf_20m float8,
	cdl_inf_500_nbr float8,
	cdl_inf_500 float8,
	agios_res float8,
	prov_req float8,
	total_nbr_gen float8,
	total_gen float8,
	gen_inf_20_nbr float8,
	gen_inf_20 float8,
	ref_saine_nbr float8,
	ref_saine_mnt float8,
	ref_saine_inf_20_nbr float8,
	ref_saine_eng_inf_20 float8,
	ref_cdl_nbr float8,
	ref_cdl_mnt float8,
	nbr_rec float8,
	mnt_rec float8,
	par_nbr_gen float8,
	par_gen float8,
	par_ref_saine_nbr float8,
	par_ref_saine_mnt float8,
	par_ref_decouvert float8,
	ref_habit float8,
	ref_media float8,
	act_decouvert_nbr float8,
	act_decouvert float8,
	act_habit_nbr float8,
	act_habit float8,
	act_media_nbr float8,
	act_media float8,
	nbr_total float8,
	nbr_renouv float8,
	nbr_relation float8,
	nbr_bilan_saisie float8,
	cre_rat_sup_90_tot float8,
	decouvert float8,
	eng_inf_20 float8,
	cct_fiche float8,
	cct_enc float8,
	cct_nbr float8,
	cct_enc_saine float8,
	cmlt_fiche float8,
	cmlt_enc float8,
	cmlt_nbr float8,
	cmlt_enc_saine float8,
	debit float8,
	debit_gen_mnt float8,
	debit_gen_nbr float8,
	debit_enc_saine float8,
	par_dge float8,
	par_nbr_gen_dge float8,
	par_gen_dge float8,
	par_saine float8,
	engsig_y_imp float8,
	engsig_enc float8,
	engsig_nbr float8,
	engsig_enc_saine float8,
	gen_ctx_mnt float8,
	gen_ctx_nbr float8,
	mnt_ciar varchar(255),
	nbr_ciar varchar(255));

-- DROP TYPE Menu;

CREATE TYPE Menu AS (
	id bigserial,
	active bool,
	checked bool,
	iconcomponent varchar(255),
	idparent int8,
	"level" int4,
	"name" varchar(255),
	url varchar(255));

-- DROP TYPE Menu_composants;

CREATE TYPE Menu_composants AS (
	"Menu_id" int8,
	composants_id int8);

-- DROP TYPE Message;

CREATE TYPE Message AS (
	id bigserial,
	codeclient varchar(255),
	compteclient varchar(255),
	idresponsemessage int8,
	"object" varchar(255),
	processstatus varchar(255),
	receiver varchar(255),
	sender varchar(255),
	status varchar(255),
	"text" varchar(255),
	"timestamp" timestamp,
	"type" varchar(255),
	classe int4,
	motif varchar(255),
	url varchar(255),
	validation bool,
	pre_classe int4,
	pre_motif varchar(255));

-- DROP TYPE Message_attachementReclamations;

CREATE TYPE Message_attachementReclamations AS (
	"Message_id" int8,
	"attachementReclamations_id" int8);

-- DROP TYPE Message_attachements;

CREATE TYPE Message_attachements AS (
	"Message_id" int8,
	attachements_id int8);

-- DROP TYPE P_TYP_ENG_BCT;

CREATE TYPE P_TYP_ENG_BCT AS (
	"TYPE_ENCR" varchar(50),
	"TYPE_ENG" varchar(50),
	"CODE_BCT" varchar(50),
	"USG" varchar(50),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE Permissions;

CREATE TYPE Permissions AS (
	id bigserial,
	menu_id int8);

-- DROP TYPE Profile;

CREATE TYPE Profile AS (
	id bigserial,
	profiletype varchar(255));

-- DROP TYPE Profile_permissions;

CREATE TYPE Profile_permissions AS (
	"Profile_id" int8,
	permissions_id int8);

-- DROP TYPE R_ACTIVITE;

CREATE TYPE R_ACTIVITE AS (
	"CDRACTV" int4,
	"CDRCONTMUTL" int4,
	"ID" varchar(5),
	"LIBL" varchar(200),
	"CORR_BCT" varchar(7),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_BIAT_PROFESSION;

CREATE TYPE R_BIAT_PROFESSION AS (
	"CDRBIATPRFS" int4,
	"ID" varchar(4),
	"LIBL" varchar(75),
	"CORR_BCT" varchar(4),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DAT_CHG" int4);

-- DROP TYPE R_CATEGORY;

CREATE TYPE R_CATEGORY AS (
	"CDRCATG" int4,
	"ID" varchar(6),
	"SYST_IND" varchar(3),
	"MNMN" varchar(10),
	"AC_CONT" varchar(35),
	"DESC" varchar(35),
	"SHRT_NAM" varchar(15),
	"LIGN_PRD" varchar(35),
	"TAXB" varchar(35),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_CODE_ENG;

CREATE TYPE R_CODE_ENG AS (
	"CDRCODENG" int4,
	"ID" varchar(10),
	"DESC" varchar(200),
	"CATG" varchar(35),
	"LIGN_PRDT" varchar(35),
	"PRIO_IMP" varchar(35),
	"DATE_DEBT" varchar(35),
	"DATE_FIN" varchar(35),
	"LIMT_REF" int4,
	"TYPE_LIMT" varchar(35),
	"DEVS" varchar(100000),
	"CATG_COMP" varchar(100000),
	"RECC_BIAT" varchar(15),
	"COD_ENG_BCT" varchar(4),
	"CDRCODENGBCT" int4,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_CODE_ENG_BCT;

CREATE TYPE R_CODE_ENG_BCT AS (
	"CDRCODENGBCT" int4,
	"CODE_BCT" varchar(4),
	"TYPE_CODE_BCT" int4,
	"LIBELLE_LONG_CODE_BCT" varchar(200),
	"LIBELLE_COURT_CODE_BCT" varchar(100),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DAT_CHG" int4);

-- DROP TYPE R_CODE_ENG_PERSO_BIAT;

CREATE TYPE R_CODE_ENG_PERSO_BIAT AS (
	"CDRCODENGRH" int4,
	"CODE_ENGG" varchar(3),
	"CODE_CRDT" varchar(3),
	"LIBL" varchar(100),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_INDUSTRY;

CREATE TYPE R_INDUSTRY AS (
	"CDRINDS" int4,
	"ID" int4,
	"DESC" varchar(100),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_LIMITES;

CREATE TYPE R_LIMITES AS (
	"CDRLIMT" int4,
	"ID" int4,
	"DESC" varchar(35),
	"SHRT_NAM" varchar(15),
	"FX_OR_TIME_BAND" varchar(2),
	"REDC_LIMT" varchar(1),
	"LIMT_MNMN" varchar(4),
	"LIMT_KEY_TYP" varchar(7),
	"LIMT_PERC" varchar(3),
	"DEFL_CHCK" varchar(2),
	"PARN_REFR" varchar(7),
	"DATDEBVLD" int4,
	"DATFINVAL" int4,
	"DERSIT" int4,
	"DAT_CHG" int4,
	datfinvld int4);

-- DROP TYPE R_RELATION;

CREATE TYPE R_RELATION AS (
	"CDRRELT" int4,
	"ID" int4,
	"DESC" varchar,
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_TARGET;

CREATE TYPE R_TARGET AS (
	"CDRTARG" int4,
	"ID" int4,
	"DESC" varchar(35),
	"SHRT_NAM" varchar(100),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DAT_CHG" int4);

-- DROP TYPE R_TYPE_CREDIT;

CREATE TYPE R_TYPE_CREDIT AS (
	"CDRCODENG" int4,
	"ID" varchar(7),
	"LIBL" varchar(200),
	"CATG" int4,
	"LIGN_PRDT" int4,
	"APPL" varchar(2),
	"LIMT_REF" int4,
	"PRIO_IMP" int4,
	"DATE_DEBT" int4,
	"DATE_FIN" int4,
	"TYPE_LIMT" varchar(3),
	"GEST_VERS" int4,
	"IND_STND" varchar(3),
	"ELEG_REFN" int4,
	"ELEG_TITR" int4,
	"ELEG_SOTGR" int4,
	"ELEG_FNG" int4,
	"ELEG_COF" int4,
	"RENV_PRRG" varchar(35),
	"CAT_TIEX" varchar(3),
	"CODE_KFCR" int4,
	"LIEN_EPRG" int4,
	"MONT_MIN" float8,
	"MONTT_MAX" float8,
	"MNT_NET_GLB_MAX" float8,
	"MNT_NET_MAX_TRX" float8,
	"TX_ENDT_MAX" float8,
	"REF_MARC" varchar(3),
	"REF_EXPR" varchar(3),
	"CLE_TX_BASE" varchar(4),
	"TYPE_DECM" varchar(4),
	"TYPE_INTR" varchar(8),
	"BASE_INTR" varchar(4),
	"MARG_STD" float4,
	"MARG_MIN" float4,
	"MARG_MAX" float4,
	"TAUX_MIN" float4,
	"TAUX_MAX" float4,
	"MARG_PENL" float4,
	"CHRG_CMP" varchar(35),
	"CHRG_ETD_ACR" varchar(35),
	"CHRG_ETD_REJ" varchar(35),
	"CHRG_RB_ANTC" varchar(35),
	"CHRG_REMB_ECH" varchar(35),
	"CHRG_COM_ENG" varchar(35),
	"COMM_PC" int4,
	"COMM_G" int4,
	"DURE_MIN" varchar(3),
	"DURE_MAX" varchar(4),
	"ECH_MAX" int4,
	"DURE_MAX_GB" varchar(5),
	"DEBL_TRNC" int4,
	"SUPP_MOB" varchar(35),
	"VALD_OFFR" varchar(3),
	"FRCH_MIN_THQ" varchar(3),
	"FRCH_MAX_THQ" varchar(3),
	"ANTC_DEBL_MAX" varchar(3),
	"VALD_TC" varchar(3),
	"FRCH_MIN_EFF" varchar(3),
	"LIEU_CONS_VM" varchar(20),
	"RECC_IMP_BIAT" varchar(6),
	"TYPE_DEBL" varchar(6),
	"COMM_MISE_IMP" varchar(15),
	"RECR_STTS" varchar,
	"CO_CODE" varchar,
	"DEPT_CODE" varchar,
	"DEVS" varchar(100000),
	"CATG_COMP" varchar(100000),
	"TYPE_REMB" varchar(9),
	"DATE_TIME" float8,
	"PER_REMB_PPL" varchar(500),
	"PER_REMB_INT" varchar(500),
	"OPTN_COMP" varchar(500),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_TYPE_ENCOUR;

CREATE TYPE R_TYPE_ENCOUR AS (
	"CDR_TYP_ENCR" int4,
	"ID" int4,
	"LIB_LONG" varchar(45),
	"LIB_CORT" varchar(15),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_TYPE_ENG;

CREATE TYPE R_TYPE_ENG AS (
	"CDRCODENG" int4,
	"ID" varchar(10),
	"LIBL" varchar(60),
	"FAML_PRCS" varchar(60),
	"LIGN_PRDT" varchar(60),
	"CATG" varchar(60),
	"LIMT_REF" int4,
	"TYPE_LIMT" varchar(60),
	"MODL_STD_MEP" varchar(60),
	"AUTR_DEVS" varchar(60),
	"DATE_DEBT" varchar(60),
	"DATE_FIN" varchar(60),
	"IND_STND" varchar(60),
	"LIEN_EPRG" varchar(60),
	"RECC_BIAT" int4,
	"ELEG_COF" varchar(60),
	"TABL_REFR" varchar(60),
	"TYPE_NOTF" varchar(60),
	"ETAP_NOTF" varchar(60),
	"DELS_NOTF" varchar(60),
	"RECR_STTS" varchar(4),
	"CURR_NO" int4,
	"DEPT_CODE" varchar(4),
	"DEVS" varchar(3),
	"DATE_TIME" float8,
	"DEVS_ENG" varchar(3),
	"TX_ENDT_MAX" varchar(60),
	"DEVS_TX" varchar(3),
	"REVN_MIN" varchar(60),
	"REVN_MAX" varchar(60),
	"CODE_KFCR" varchar(60),
	"SUPP_MOB" varchar(60),
	"LIEU_CONS_VM" varchar(60),
	"QUTT_FIN" varchar(60),
	"ELGB_TRE" varchar(60),
	"QUTT_FIN_TRE" varchar(60),
	"FRCH_THQ_INT" varchar(60),
	"MONT" varchar(60),
	"MNT_NET_GLB" varchar(60),
	"MNT_NET_TRX" varchar(60),
	"CAT_TIEX" varchar(60),
	"CLE_TX_BASE" varchar(60),
	"TYPE_DECM" varchar(60),
	"TYPE_INTR" varchar(60),
	"BASE_INTR" varchar(60),
	"MARG_STD" varchar(60),
	"MARG" varchar(60),
	"CHRG_CMP" varchar(60),
	"CHRG_ETD_ACR" varchar(60),
	"CHRG_ETD_REJ" varchar(60),
	"CHRG_RB_ANTC" varchar(60),
	"CHRG_REMB_ECH" varchar(60),
	"CHRG_COM_ENG" varchar(60),
	"COMM_PCG" varchar(60),
	"COMM_MISE_IMP" varchar(60),
	"TYPE_REMB" varchar(60),
	"DEBL_TRNC" varchar(60),
	"NBR_TRC" varchar(60),
	"PER_REMB_PPL" varchar(60),
	"PER_REMB_INT" varchar(60),
	"DURE" varchar(60),
	"VALD_OFFR" varchar(60),
	"PERD_LATN" varchar(60),
	"FRCH_THQ_PPL" varchar(60),
	"ANTC_DEBL" varchar(60),
	"VALD_TC" varchar(60),
	"ELEG_REFN" varchar(60),
	"ELEG_TITR" varchar(60),
	"ELEG_SOTG" varchar(60),
	"ELEG_FNG" varchar(60),
	"LIEN_PROM_IMMO" varchar(60),
	"CATG_COMP" varchar(60),
	"PRIO_IMP" varchar(60),
	"ELEG_DHMN" varchar(60),
	"CRD_AUTR_TYPE_TAUX" varchar(60),
	"TYPS_ENG_LIES" varchar(60),
	"MRG_B_FONDS" varchar(60),
	"ELEG_TUNS" varchar(60),
	"CALC_TUNS_CH" varchar(60),
	"METH_MEP" varchar(60),
	"EXEC_VIR_DEBL" varchar(60),
	"CPT_INTR_DEBL" varchar(60),
	"TAUX_EQUV" varchar(60),
	"CPT_INT_TRES_A_RECV" varchar(60),
	"CPT_PL_TRES_A_RECV" varchar(60),
	"CPT_INT_TRES_RECV" varchar(60),
	"CPT_INT_TRES_IMP" varchar(60),
	"CPT_PPL_IMP" varchar(60),
	"CPT_PPL_RECV" varchar(60),
	"INDIC_FOND_ETAT" varchar(60),
	"RAPP_GAR_CRD" varchar(60),
	"MNT_INV_MAX" varchar(60),
	"OPTN_COMP" varchar(60),
	"CPT_INT_RETR_TRES_A_RECV" varchar(60),
	"CPT_PL_INT_RETAR_TRES" varchar(60),
	"CPT_INT_RETR_RECV" varchar(60),
	"COMP_FOND" varchar(60),
	"ELIG_FGIC" varchar(60),
	"ELEG_SARE" varchar(60),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_TYPE_ENG_MD;

CREATE TYPE R_TYPE_ENG_MD AS (
	"CDRCODENG" int4,
	"ID" varchar(7),
	"DESC" varchar(60),
	"CATG" int4,
	"LIGN_PRDT" varchar(3),
	"PRIO_IMP" int4,
	"CODE_KFCR" varchar(4),
	"DATE_DEBUT" int4,
	"DATE_FIN" int4,
	"TYPE_LIMT" varchar(3),
	"TYPE_PRDT" varchar(10),
	"MODL" varchar(3),
	"APR_PART" varchar(3),
	"APR_ECH_AUT" varchar(3),
	"LIMIT_REF" int4,
	"MOIS_INDV" varchar(3),
	"REF_MARC" varchar(3),
	"REF_CNTR_MARC" varchar(3),
	"TX_FINN" varchar(6),
	"COMM_RISQ" varchar(15),
	"PERD_COM_RISQ" varchar(15),
	"COMM_MEP_EPS" varchar(15),
	"COM_MODF_CLNT" varchar(15),
	"COMM_M_JEU" varchar(15),
	"RECC_BIAT" varchar(15),
	"RECR_STTS" varchar(4),
	"CO_CODE" varchar(40),
	"DEPT_CODE" varchar(10),
	"DEVS" varchar(1000),
	"CATG_COMP" varchar(1000),
	"COM_APRM" varchar(35),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE R_UNITGEST;

CREATE TYPE R_UNITGEST AS (
	"CDR_UNIT_GEST" int4,
	"ID" varchar(20),
	"AREA" varchar(20),
	"NAME" varchar(50),
	"TELEPHONE_NO" varchar(16),
	"RECORD_STATUS" varchar(3),
	"CO_CODE" varchar(35),
	"DEPT_LEVEL" varchar(15),
	"DEPT_PARENT" int4,
	"CODE_AGENCE" varchar(11),
	"CODE_AGENCE_BCT" varchar(20),
	"CODE_AGENCE_RIB" varchar(100),
	"CODE_COMPANY" varchar(100),
	"ATQ_WU" varchar(11),
	"LR_LONGITUDE" varchar(20),
	"LR_LATITUDE" varchar(20),
	"LR_GOUVERNERAT" varchar(35),
	"TYPE_AGENCE" varchar(50),
	"CLSS" varchar(50),
	"DATE_OUVT" varchar(16),
	"DATDEBVLD" int4,
	"DATFINVLD" int4,
	"DERSIT" int4,
	"DATCHG" int4);

-- DROP TYPE Tree;

CREATE TYPE Tree AS (
	id bigserial,
	agence varchar(255),
	pole varchar(255),
	region varchar(255),
	"zone" varchar(255));

-- DROP TYPE Url;

CREATE TYPE Url AS (
	id bigserial,
	component varchar(255),
	url varchar(255));

-- DROP TYPE Users;

CREATE TYPE Users AS (
	id bigserial,
	libelle varchar(255),
	email varchar(255),
	lastlogout timestamp,
	registerdate timestamp,
	status varchar(255),
	userfirstname varchar(255),
	userlastname varchar(255),
	username varchar(255),
	userpassword varchar(255),
	profile varchar(255),
	initials varchar(255));

-- DROP TYPE Users_histories;

CREATE TYPE Users_histories AS (
	"User_id" int8,
	histories_id int8);

-- DROP TYPE dwm_pd_payment_due_details;

CREATE TYPE dwm_pd_payment_due_details AS (
	s varchar(255),
	cpte varchar(255),
	cpte_24 varchar(255),
	currency varchar(255),
	customer varchar(255),
	date_ech varchar(255),
	id varchar(255),
	imp_int varchar(255),
	imp_int_os varchar(255),
	imp_int_penalit varchar(255),
	imp_int_penalit_os varchar(255),
	imp_int_retard varchar(255),
	imp_int_retard_os varchar(255),
	imp_pr varchar(255),
	imp_pr_os varchar(255),
	lib_type_eng varchar(255),
	periode varchar(255),
	reference varchar(255),
	type_eng varchar(255));

-- DROP TYPE risk_classe;

CREATE TYPE risk_classe AS (
	s varchar(255),
	agios varchar(255),
	clascon varchar(255),
	clasgel varchar(255),
	clasimp varchar(255),
	clasmaxident varchar(255),
	classub varchar(255),
	cloture varchar(255),
	cpte varchar(255),
	datcloture varchar(255),
	ech_anc varchar(255),
	identif varchar(255),
	impinter varchar(255),
	impprinc varchar(255),
	mtf_con varchar(255),
	mtf_sub varchar(255),
	mvt varchar(255),
	periode varchar(255),
	soldcpte varchar(255));

-- DROP TYPE risk_cpte;

CREATE TYPE risk_cpte AS (
	s varchar(255),
	classe varchar(255),
	cpte varchar(255),
	graded varchar(255),
	motif varchar(255),
	periode varchar(255),
	risk_brut varchar(255),
	risk_net varchar(255));

-- DROP TYPE tab1;

CREATE TYPE tab1 AS (
	cpte varchar(255),
	actfin int8,
	act_biat int8,
	agios_ech_int int8,
	agios_eff_imp int8,
	agios_eff_imp_deb int8,
	agios_res int8,
	agios_x int8,
	assur int8,
	avalbq int8,
	classe varchar(255),
	codrisk varchar(255),
	cotunace int8,
	depots int8,
	dont_cesur int8,
	ecart_prov int8,
	engsiga int8,
	engsigb int8,
	fng int8,
	garbq int8,
	garded int8,
	garetat int8,
	gar_even int8,
	hypo int8,
	idbct varchar(255),
	identif varchar(255),
	motif varchar(255),
	nom varchar(255),
	periode timestamp,
	pod int8,
	prov_adit int8,
	prov_req int8,
	pro_cons int8,
	risk_brut int8,
	risk_net int8,
	solde_agios_deb_tri int8,
	typeidbct varchar(255));

-- DROP TYPE tab2;

CREATE TYPE tab2 AS (
	cpte varchar(255),
	agios int8,
	clascon varchar(255),
	clasgel varchar(255),
	clasimp varchar(255),
	clasmaxident varchar(255),
	classub varchar(255),
	cloture varchar(255),
	datcloture varchar(255),
	ech_anc varchar(255),
	identif varchar(255),
	impinter int8,
	impprinc int8,
	mtf_con varchar(255),
	mtf_sub varchar(255),
	mvt int8,
	periode timestamp,
	soldcpte int8);

-- DROP TYPE _Attachement;

CREATE TYPE _Attachement (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Attachement,
	DELIMITER = ',');

-- DROP TYPE _AttachementReclamation;

CREATE TYPE _AttachementReclamation (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = AttachementReclamation,
	DELIMITER = ',');

-- DROP TYPE _Chat;

CREATE TYPE _Chat (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Chat,
	DELIMITER = ',');

-- DROP TYPE _Chat_messages;

CREATE TYPE _Chat_messages (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Chat_messages,
	DELIMITER = ',');

-- DROP TYPE _Chat_users;

CREATE TYPE _Chat_users (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Chat_users,
	DELIMITER = ',');

-- DROP TYPE _Classification;

CREATE TYPE _Classification (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Classification,
	DELIMITER = ',');

-- DROP TYPE _Classification_attachements;

CREATE TYPE _Classification_attachements (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Classification_attachements,
	DELIMITER = ',');

-- DROP TYPE _Client;

CREATE TYPE _Client (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Client,
	DELIMITER = ',');

-- DROP TYPE _Composant;

CREATE TYPE _Composant (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Composant,
	DELIMITER = ',');

-- DROP TYPE _DownloadPin;

CREATE TYPE _DownloadPin (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = DownloadPin,
	DELIMITER = ',');

-- DROP TYPE _E_ACCOUNT;

CREATE TYPE _E_ACCOUNT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_ACCOUNT,
	DELIMITER = ',');

-- DROP TYPE _E_ACCOUNT_PERSO_BIAT;

CREATE TYPE _E_ACCOUNT_PERSO_BIAT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_ACCOUNT_PERSO_BIAT,
	DELIMITER = ',');

-- DROP TYPE _E_ACCOUNT_SOLDE;

CREATE TYPE _E_ACCOUNT_SOLDE (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_ACCOUNT_SOLDE,
	DELIMITER = ',');

-- DROP TYPE _E_ACCOUNT_SOLDE_PERSO_BIAT;

CREATE TYPE _E_ACCOUNT_SOLDE_PERSO_BIAT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_ACCOUNT_SOLDE_PERSO_BIAT,
	DELIMITER = ',');

-- DROP TYPE _E_CONTRAT;

CREATE TYPE _E_CONTRAT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_CONTRAT,
	DELIMITER = ',');

-- DROP TYPE _E_CONTRAT_PERSO_BIAT;

CREATE TYPE _E_CONTRAT_PERSO_BIAT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_CONTRAT_PERSO_BIAT,
	DELIMITER = ',');

-- DROP TYPE _E_CURRENCY;

CREATE TYPE _E_CURRENCY (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_CURRENCY,
	DELIMITER = ',');

-- DROP TYPE _E_CUSTOMER;

CREATE TYPE _E_CUSTOMER (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_CUSTOMER,
	DELIMITER = ',');

-- DROP TYPE _E_CUSTOMER_RELATION;

CREATE TYPE _E_CUSTOMER_RELATION (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_CUSTOMER_RELATION,
	DELIMITER = ',');

-- DROP TYPE _E_DRAWINGS;

CREATE TYPE _E_DRAWINGS (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_DRAWINGS,
	DELIMITER = ',');

-- DROP TYPE _E_ENCOURS;

CREATE TYPE _E_ENCOURS (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_ENCOURS,
	DELIMITER = ',');

-- DROP TYPE _E_ENCOURS_PERSO_BIAT;

CREATE TYPE _E_ENCOURS_PERSO_BIAT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_ENCOURS_PERSO_BIAT,
	DELIMITER = ',');

-- DROP TYPE _E_LC;

CREATE TYPE _E_LC (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_LC,
	DELIMITER = ',');

-- DROP TYPE _E_LD;

CREATE TYPE _E_LD (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_LD,
	DELIMITER = ',');

-- DROP TYPE _E_MD;

CREATE TYPE _E_MD (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_MD,
	DELIMITER = ',');

-- DROP TYPE _E_MG;

CREATE TYPE _E_MG (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_MG,
	DELIMITER = ',');

-- DROP TYPE _E_PD;

CREATE TYPE _E_PD (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_PD,
	DELIMITER = ',');

-- DROP TYPE _E_PD_DETAIL;

CREATE TYPE _E_PD_DETAIL (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_PD_DETAIL,
	DELIMITER = ',');

-- DROP TYPE _E_PD_MONTANT;

CREATE TYPE _E_PD_MONTANT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_PD_MONTANT,
	DELIMITER = ',');

-- DROP TYPE _E_TITRE_CREDIT;

CREATE TYPE _E_TITRE_CREDIT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_TITRE_CREDIT,
	DELIMITER = ',');

-- DROP TYPE _E_TITRE_CREDIT_ECHEANCIER;

CREATE TYPE _E_TITRE_CREDIT_ECHEANCIER (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_TITRE_CREDIT_ECHEANCIER,
	DELIMITER = ',');

-- DROP TYPE _E_TITRE_CREDIT_ECHEANCIER_temp;

CREATE TYPE _E_TITRE_CREDIT_ECHEANCIER_temp (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = E_TITRE_CREDIT_ECHEANCIER_temp,
	DELIMITER = ',');

-- DROP TYPE _Functions;

CREATE TYPE _Functions (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Functions,
	DELIMITER = ',');

-- DROP TYPE _History;

CREATE TYPE _History (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = History,
	DELIMITER = ',');

-- DROP TYPE _LST;

CREATE TYPE _LST (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = LST,
	DELIMITER = ',');

-- DROP TYPE _Menu;

CREATE TYPE _Menu (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Menu,
	DELIMITER = ',');

-- DROP TYPE _Menu_composants;

CREATE TYPE _Menu_composants (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Menu_composants,
	DELIMITER = ',');

-- DROP TYPE _Message;

CREATE TYPE _Message (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Message,
	DELIMITER = ',');

-- DROP TYPE _Message_attachementReclamations;

CREATE TYPE _Message_attachementReclamations (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Message_attachementReclamations,
	DELIMITER = ',');

-- DROP TYPE _Message_attachements;

CREATE TYPE _Message_attachements (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Message_attachements,
	DELIMITER = ',');

-- DROP TYPE _P_TYP_ENG_BCT;

CREATE TYPE _P_TYP_ENG_BCT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = P_TYP_ENG_BCT,
	DELIMITER = ',');

-- DROP TYPE _Permissions;

CREATE TYPE _Permissions (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Permissions,
	DELIMITER = ',');

-- DROP TYPE _Profile;

CREATE TYPE _Profile (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Profile,
	DELIMITER = ',');

-- DROP TYPE _Profile_permissions;

CREATE TYPE _Profile_permissions (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Profile_permissions,
	DELIMITER = ',');

-- DROP TYPE _R_ACTIVITE;

CREATE TYPE _R_ACTIVITE (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_ACTIVITE,
	DELIMITER = ',');

-- DROP TYPE _R_BIAT_PROFESSION;

CREATE TYPE _R_BIAT_PROFESSION (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_BIAT_PROFESSION,
	DELIMITER = ',');

-- DROP TYPE _R_CATEGORY;

CREATE TYPE _R_CATEGORY (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_CATEGORY,
	DELIMITER = ',');

-- DROP TYPE _R_CODE_ENG;

CREATE TYPE _R_CODE_ENG (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_CODE_ENG,
	DELIMITER = ',');

-- DROP TYPE _R_CODE_ENG_BCT;

CREATE TYPE _R_CODE_ENG_BCT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_CODE_ENG_BCT,
	DELIMITER = ',');

-- DROP TYPE _R_CODE_ENG_PERSO_BIAT;

CREATE TYPE _R_CODE_ENG_PERSO_BIAT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_CODE_ENG_PERSO_BIAT,
	DELIMITER = ',');

-- DROP TYPE _R_INDUSTRY;

CREATE TYPE _R_INDUSTRY (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_INDUSTRY,
	DELIMITER = ',');

-- DROP TYPE _R_LIMITES;

CREATE TYPE _R_LIMITES (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_LIMITES,
	DELIMITER = ',');

-- DROP TYPE _R_RELATION;

CREATE TYPE _R_RELATION (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_RELATION,
	DELIMITER = ',');

-- DROP TYPE _R_TARGET;

CREATE TYPE _R_TARGET (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_TARGET,
	DELIMITER = ',');

-- DROP TYPE _R_TYPE_CREDIT;

CREATE TYPE _R_TYPE_CREDIT (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_TYPE_CREDIT,
	DELIMITER = ',');

-- DROP TYPE _R_TYPE_ENCOUR;

CREATE TYPE _R_TYPE_ENCOUR (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_TYPE_ENCOUR,
	DELIMITER = ',');

-- DROP TYPE _R_TYPE_ENG;

CREATE TYPE _R_TYPE_ENG (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_TYPE_ENG,
	DELIMITER = ',');

-- DROP TYPE _R_TYPE_ENG_MD;

CREATE TYPE _R_TYPE_ENG_MD (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_TYPE_ENG_MD,
	DELIMITER = ',');

-- DROP TYPE _R_UNITGEST;

CREATE TYPE _R_UNITGEST (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = R_UNITGEST,
	DELIMITER = ',');

-- DROP TYPE _Tree;

CREATE TYPE _Tree (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Tree,
	DELIMITER = ',');

-- DROP TYPE _Url;

CREATE TYPE _Url (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Url,
	DELIMITER = ',');

-- DROP TYPE _Users;

CREATE TYPE _Users (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Users,
	DELIMITER = ',');

-- DROP TYPE _Users_histories;

CREATE TYPE _Users_histories (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = Users_histories,
	DELIMITER = ',');

-- DROP TYPE _dwm_pd_payment_due_details;

CREATE TYPE _dwm_pd_payment_due_details (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = dwm_pd_payment_due_details,
	DELIMITER = ',');

-- DROP TYPE _risk_classe;

CREATE TYPE _risk_classe (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = risk_classe,
	DELIMITER = ',');

-- DROP TYPE _risk_cpte;

CREATE TYPE _risk_cpte (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = risk_cpte,
	DELIMITER = ',');

-- DROP TYPE _tab1;

CREATE TYPE _tab1 (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = tab1,
	DELIMITER = ',');

-- DROP TYPE _tab2;

CREATE TYPE _tab2 (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = tab2,
	DELIMITER = ',');

-- DROP SEQUENCE public."AttachementReclamation_id_seq";

CREATE SEQUENCE public."AttachementReclamation_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."AttachementReclamation_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."AttachementReclamation_id_seq" TO postgres;

-- DROP SEQUENCE public."Attachement_id_seq";

CREATE SEQUENCE public."Attachement_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Attachement_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Attachement_id_seq" TO postgres;

-- DROP SEQUENCE public."Chat_chat_id_seq";

CREATE SEQUENCE public."Chat_chat_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Chat_chat_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Chat_chat_id_seq" TO postgres;

-- DROP SEQUENCE public."Classification_id_seq";

CREATE SEQUENCE public."Classification_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Classification_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Classification_id_seq" TO postgres;

-- DROP SEQUENCE public."Composant_id_seq";

CREATE SEQUENCE public."Composant_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Composant_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Composant_id_seq" TO postgres;

-- DROP SEQUENCE public."DownloadPin_id_seq";

CREATE SEQUENCE public."DownloadPin_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."DownloadPin_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."DownloadPin_id_seq" TO postgres;

-- DROP SEQUENCE public."Functions_id_seq";

CREATE SEQUENCE public."Functions_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Functions_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Functions_id_seq" TO postgres;

-- DROP SEQUENCE public."History_id_seq";

CREATE SEQUENCE public."History_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."History_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."History_id_seq" TO postgres;

-- DROP SEQUENCE public."Menu_id_seq";

CREATE SEQUENCE public."Menu_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Menu_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Menu_id_seq" TO postgres;

-- DROP SEQUENCE public."Message_id_seq";

CREATE SEQUENCE public."Message_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Message_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Message_id_seq" TO postgres;

-- DROP SEQUENCE public."Permissions_id_seq";

CREATE SEQUENCE public."Permissions_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Permissions_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Permissions_id_seq" TO postgres;

-- DROP SEQUENCE public."Profile_id_seq";

CREATE SEQUENCE public."Profile_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Profile_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Profile_id_seq" TO postgres;

-- DROP SEQUENCE public."Tree_id_seq";

CREATE SEQUENCE public."Tree_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Tree_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Tree_id_seq" TO postgres;

-- DROP SEQUENCE public."Url_id_seq";

CREATE SEQUENCE public."Url_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Url_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Url_id_seq" TO postgres;

-- DROP SEQUENCE public."Users_id_seq";

CREATE SEQUENCE public."Users_id_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public."Users_id_seq" OWNER TO postgres;
GRANT ALL ON SEQUENCE public."Users_id_seq" TO postgres;

-- DROP SEQUENCE public.account_perso_biat_seq;

CREATE SEQUENCE public.account_perso_biat_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.account_perso_biat_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.account_perso_biat_seq TO postgres;

-- DROP SEQUENCE public.account_seq;

CREATE SEQUENCE public.account_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.account_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.account_seq TO postgres;

-- DROP SEQUENCE public.contrat_seq;

CREATE SEQUENCE public.contrat_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.contrat_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.contrat_seq TO postgres;

-- DROP SEQUENCE public.customer_seq;

CREATE SEQUENCE public.customer_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.customer_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.customer_seq TO postgres;

-- DROP SEQUENCE public.e_account_solde_perso_biat_seq;

CREATE SEQUENCE public.e_account_solde_perso_biat_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_account_solde_perso_biat_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_account_solde_perso_biat_seq TO postgres;

-- DROP SEQUENCE public.e_account_solde_seq;

CREATE SEQUENCE public.e_account_solde_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_account_solde_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_account_solde_seq TO postgres;

-- DROP SEQUENCE public.e_contrat_perso_biat_seq;

CREATE SEQUENCE public.e_contrat_perso_biat_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_contrat_perso_biat_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_contrat_perso_biat_seq TO postgres;

-- DROP SEQUENCE public.e_currency_seq;

CREATE SEQUENCE public.e_currency_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_currency_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_currency_seq TO postgres;

-- DROP SEQUENCE public.e_customer_relation_seq;

CREATE SEQUENCE public.e_customer_relation_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_customer_relation_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_customer_relation_seq TO postgres;

-- DROP SEQUENCE public.e_drawings_seq;

CREATE SEQUENCE public.e_drawings_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_drawings_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_drawings_seq TO postgres;

-- DROP SEQUENCE public.e_encours_perso_biat_seq;

CREATE SEQUENCE public.e_encours_perso_biat_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_encours_perso_biat_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_encours_perso_biat_seq TO postgres;

-- DROP SEQUENCE public.e_lc_seq;

CREATE SEQUENCE public.e_lc_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_lc_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_lc_seq TO postgres;

-- DROP SEQUENCE public.e_ld_seq;

CREATE SEQUENCE public.e_ld_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_ld_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_ld_seq TO postgres;

-- DROP SEQUENCE public.e_md_seq;

CREATE SEQUENCE public.e_md_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_md_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_md_seq TO postgres;

-- DROP SEQUENCE public.e_mg_seq;

CREATE SEQUENCE public.e_mg_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_mg_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_mg_seq TO postgres;

-- DROP SEQUENCE public.e_pd_detail_seq;

CREATE SEQUENCE public.e_pd_detail_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_pd_detail_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_pd_detail_seq TO postgres;

-- DROP SEQUENCE public.e_pd_montant_seq;

CREATE SEQUENCE public.e_pd_montant_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_pd_montant_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_pd_montant_seq TO postgres;

-- DROP SEQUENCE public.e_pd_seq;

CREATE SEQUENCE public.e_pd_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_pd_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_pd_seq TO postgres;

-- DROP SEQUENCE public.e_titre_credit_echeancier_seq;

CREATE SEQUENCE public.e_titre_credit_echeancier_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_titre_credit_echeancier_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_titre_credit_echeancier_seq TO postgres;

-- DROP SEQUENCE public.e_titre_credit_seq;

CREATE SEQUENCE public.e_titre_credit_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.e_titre_credit_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.e_titre_credit_seq TO postgres;

-- DROP SEQUENCE public.encours_seq;

CREATE SEQUENCE public.encours_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.encours_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.encours_seq TO postgres;

-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.hibernate_sequence OWNER TO postgres;
GRANT ALL ON SEQUENCE public.hibernate_sequence TO postgres;

-- DROP SEQUENCE public.p_typ_eng_bct_seq;

CREATE SEQUENCE public.p_typ_eng_bct_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.p_typ_eng_bct_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.p_typ_eng_bct_seq TO postgres;

-- DROP SEQUENCE public.r_activite_seq;

CREATE SEQUENCE public.r_activite_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_activite_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_activite_seq TO postgres;

-- DROP SEQUENCE public.r_biat_profession_seq;

CREATE SEQUENCE public.r_biat_profession_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_biat_profession_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_biat_profession_seq TO postgres;

-- DROP SEQUENCE public.r_category_seq;

CREATE SEQUENCE public.r_category_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_category_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_category_seq TO postgres;

-- DROP SEQUENCE public.r_code_eng_bct_seq;

CREATE SEQUENCE public.r_code_eng_bct_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_code_eng_bct_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_code_eng_bct_seq TO postgres;

-- DROP SEQUENCE public.r_code_eng_perso_biat_seq;

CREATE SEQUENCE public.r_code_eng_perso_biat_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_code_eng_perso_biat_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_code_eng_perso_biat_seq TO postgres;

-- DROP SEQUENCE public.r_code_eng_seq;

CREATE SEQUENCE public.r_code_eng_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_code_eng_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_code_eng_seq TO postgres;

-- DROP SEQUENCE public.r_industry_seq;

CREATE SEQUENCE public.r_industry_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_industry_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_industry_seq TO postgres;

-- DROP SEQUENCE public.r_limites_seq;

CREATE SEQUENCE public.r_limites_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_limites_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_limites_seq TO postgres;

-- DROP SEQUENCE public.r_relation_seq;

CREATE SEQUENCE public.r_relation_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_relation_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_relation_seq TO postgres;

-- DROP SEQUENCE public.r_target_seq;

CREATE SEQUENCE public.r_target_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_target_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_target_seq TO postgres;

-- DROP SEQUENCE public.r_type_credit_seq;

CREATE SEQUENCE public.r_type_credit_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_type_credit_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_type_credit_seq TO postgres;

-- DROP SEQUENCE public.r_type_encour_seq;

CREATE SEQUENCE public.r_type_encour_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_type_encour_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_type_encour_seq TO postgres;

-- DROP SEQUENCE public.r_type_eng_md_seq;

CREATE SEQUENCE public.r_type_eng_md_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_type_eng_md_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_type_eng_md_seq TO postgres;

-- DROP SEQUENCE public.r_type_eng_seq;

CREATE SEQUENCE public.r_type_eng_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_type_eng_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_type_eng_seq TO postgres;

-- DROP SEQUENCE public.r_unitgest_seq;

CREATE SEQUENCE public.r_unitgest_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.r_unitgest_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE public.r_unitgest_seq TO postgres;
-- public."Attachement" definition

-- Drop table

-- DROP TABLE public."Attachement";

CREATE TABLE public."Attachement" (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	"path" varchar(255) NULL,
	"size" varchar(255) NULL,
	"type" varchar(255) NULL,
	CONSTRAINT "Attachement_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Attachement" OWNER TO postgres;
GRANT ALL ON TABLE public."Attachement" TO postgres;


-- public."AttachementReclamation" definition

-- Drop table

-- DROP TABLE public."AttachementReclamation";

CREATE TABLE public."AttachementReclamation" (
	id bigserial NOT NULL,
	nc varchar(255) NULL,
	"ref" varchar(2550) NULL,
	sf varchar(255) NULL,
	"name" varchar(255) NULL,
	"path" varchar(255) NULL,
	"size" varchar(255) NULL,
	"type" varchar(255) NULL,
	dateoperation varchar(255) NULL,
	datevaleur varchar(255) NULL,
	libelleoperation varchar(255) NULL,
	montant varchar(255) NULL,
	CONSTRAINT "AttachementReclamation_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."AttachementReclamation" OWNER TO postgres;
GRANT ALL ON TABLE public."AttachementReclamation" TO postgres;


-- public."Chat" definition

-- Drop table

-- DROP TABLE public."Chat";

CREATE TABLE public."Chat" (
	chat_id bigserial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT "Chat_pkey" PRIMARY KEY (chat_id)
);

-- Permissions

ALTER TABLE public."Chat" OWNER TO postgres;
GRANT ALL ON TABLE public."Chat" TO postgres;


-- public."Client" definition

-- Drop table

-- DROP TABLE public."Client";

CREATE TABLE public."Client" (
	account varchar(255) NOT NULL,
	code varchar(255) NULL,
	profile varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT "Client_pkey" PRIMARY KEY (account)
);

-- Permissions

ALTER TABLE public."Client" OWNER TO postgres;
GRANT ALL ON TABLE public."Client" TO postgres;


-- public."Composant" definition

-- Drop table

-- DROP TABLE public."Composant";

CREATE TABLE public."Composant" (
	id bigserial NOT NULL,
	description varchar(8000) NULL,
	query varchar(255) NULL,
	title varchar(255) NULL,
	createdby varchar(255) NULL,
	"timestamp" timestamp NULL,
	CONSTRAINT "Composant_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Composant" OWNER TO postgres;
GRANT ALL ON TABLE public."Composant" TO postgres;


-- public."E_ACCOUNT" definition

-- Drop table

-- DROP TABLE public."E_ACCOUNT";

CREATE TABLE public."E_ACCOUNT" (
	"CDRCONTMUTL" int4 NULL,
	"ID" varchar NOT NULL,
	"CUST" varchar NULL,
	"CATG" varchar NULL,
	"ACCN_TITL_1" varchar NULL,
	"ACCN_TITL_2" varchar NULL,
	"SHRT_TITL" varchar NULL,
	"MNMN" varchar NULL,
	"CURR" varchar NULL,
	"LIMT_REF" varchar NULL,
	"ACCN_OFFC" varchar NULL,
	"POST_REST" varchar NULL,
	"INTR_COMP_ACCT" varchar NULL,
	"COND_GRP" varchar NULL,
	"INCT_MARK" varchar NULL,
	"OPNN_DATE" int4 NULL,
	"LINK_TO_LIMIT" varchar NULL,
	"CLSR_DATE" int4 NULL,
	"CHRG_CCY" varchar NULL,
	"CHRG_MKT" varchar NULL,
	"INTR_CCY" varchar NULL,
	"INTR_MKT" varchar NULL,
	"ALL_NETT" varchar NULL,
	"SING_LIMIT" varchar NULL,
	"CLSD_ONLN" varchar NULL,
	"CO_CODE" varchar NULL,
	"RIB" varchar NULL,
	"Comp_CTOS" varchar NULL,
	"AUTR_MOTF_OUV" varchar NULL,
	"CART_EPRG" varchar NULL,
	"CU_AUTR_REST" varchar NULL,
	"EMP_DEMR" varchar NULL,
	"FORW_MVMT" varchar NULL,
	"INT_LIQ_CCY" varchar NULL,
	"INT_LIQU_ACCT" varchar NULL,
	"MOTF_OUVR" varchar NULL,
	"NATR_COMP" varchar NULL,
	"NUM_LIVR" varchar NULL,
	"OPT_SIGN" varchar NULL,
	"OPTN_COMP" varchar NULL,
	"OTHR_OFFC" varchar NULL,
	"ACCT_CLSE_DATE" int4 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NULL,
	CONSTRAINT "E_ACCOUNT_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_ACCOUNT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_ACCOUNT" TO postgres;


-- public."E_ACCOUNT_PERSO_BIAT" definition

-- Drop table

-- DROP TABLE public."E_ACCOUNT_PERSO_BIAT";

CREATE TABLE public."E_ACCOUNT_PERSO_BIAT" (
	"CDRCONTRH" int4 NULL,
	"ID" varchar NOT NULL,
	"CUST" varchar NULL,
	"CATG" varchar NULL,
	"ACCN_TITL_1" varchar NULL,
	"ACCN_TITL_2" varchar NULL,
	"SHRT_TITL" varchar NULL,
	"MNMN" varchar NULL,
	"CURR" varchar NULL,
	"LIMT_REF" varchar NULL,
	"ACCN_OFFC" varchar NULL,
	"POST_REST" int4 NULL,
	"INTR_COMP_ACCT" varchar NULL,
	"COND_GRP" varchar NULL,
	"INCT_MARK" varchar NULL,
	"OPNN_DATE" varchar NULL,
	"LINK_TO_LIMIT" varchar NULL,
	"CLSR_DATE" varchar NULL,
	"CHRG_CCY" varchar NULL,
	"CHRG_MKT" varchar NULL,
	"INTR_CCY" varchar NULL,
	"INTR_MKT" varchar NULL,
	"ALLW_NETT" varchar NULL,
	"SING_LIMIT" varchar NULL,
	"CLSD_ONLN" varchar NULL,
	"CO_CODE" varchar NULL,
	"RIB" varchar NULL,
	"Comp_CTOS" varchar NULL,
	"AUTR_MOTF_OUV" varchar NULL,
	"CART_EPRG" varchar NULL,
	"CU_AUTR_REST" int4 NULL,
	"EMP_DEMR" varchar NULL,
	"FORW_MVMT" varchar NULL,
	"INT_LIQ_CCY" varchar NULL,
	"INT_LIQU_ACCT" varchar NULL,
	"MOTF_OUVR" varchar NULL,
	"NATR_COMP" varchar NULL,
	"NUM_LIVR" varchar NULL,
	"OPT_SIGN" varchar NULL,
	"OPTN_COMP" varchar NULL,
	"OTHR_OFFC" varchar NULL,
	"ACCT_CLSE_DATE" int4 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NULL,
	CONSTRAINT "E_ACCOUNT_PERSO_BIAT_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_ACCOUNT_PERSO_BIAT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_ACCOUNT_PERSO_BIAT" TO postgres;


-- public."E_ACCOUNT_SOLDE" definition

-- Drop table

-- DROP TABLE public."E_ACCOUNT_SOLDE";

CREATE TABLE public."E_ACCOUNT_SOLDE" (
	"CDRCONTMUTL" int4 NULL,
	"ID" varchar(19) NOT NULL,
	"ACCR_CHG_AMNT" varchar(19) NULL,
	"ACCR_CHG_CATG" varchar(6) NULL,
	"ACCR_CR_AMNT" varchar(19) NULL,
	"ACCR_CR_CATG" varchar(6) NULL,
	"ACCR_DR_AMNT" varchar(19) NULL,
	"ACCR_DR_CATG" varchar(6) NULL,
	"OPEN_ACTL_BAL" varchar(19) NULL,
	"OPEN_CLRD_BAL" varchar(19) NULL,
	"ONLN_ACTL_BAL" varchar(19) NULL,
	"ONLN_CLRD_BAL" varchar(19) NULL,
	"WORK_BALN" varchar(19) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_ACCOUNT_SOLDE_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_ACCOUNT_SOLDE" OWNER TO postgres;
GRANT ALL ON TABLE public."E_ACCOUNT_SOLDE" TO postgres;


-- public."E_ACCOUNT_SOLDE_PERSO_BIAT" definition

-- Drop table

-- DROP TABLE public."E_ACCOUNT_SOLDE_PERSO_BIAT";

CREATE TABLE public."E_ACCOUNT_SOLDE_PERSO_BIAT" (
	"CDRCONTRH" int4 NULL,
	"ID" varchar(19) NOT NULL,
	"ACCR_CHG_AMNT" varchar(19) NULL,
	"ACCR_CHG_CATG" varchar(19) NULL,
	"ACCR_CR_AMNT" varchar(19) NULL,
	"ACCR_CR_CATG" varchar(19) NULL,
	"ACCR_DR_AMNT" varchar(19) NULL,
	"ACCR_DR_CATG" varchar(19) NULL,
	"OPEN_ACTUAL_BAL" varchar(19) NULL,
	"OPEN_CLEARED_BAL" varchar(19) NULL,
	"ONLINE_ACTUAL_BAL" varchar(19) NULL,
	"ONLINE_CLEARED_BAL" varchar(19) NULL,
	"WORKING_BALANCE" varchar(19) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_ACCOUNT_SOLDE_PERSO_BIAT_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_ACCOUNT_SOLDE_PERSO_BIAT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_ACCOUNT_SOLDE_PERSO_BIAT" TO postgres;


-- public."E_CONTRAT" definition

-- Drop table

-- DROP TABLE public."E_CONTRAT";

CREATE TABLE public."E_CONTRAT" (
	"CDRCONTMUTL" int4 NULL,
	"REF_CONT" varchar NOT NULL,
	"REF_CRDT" varchar NOT NULL,
	"CUST" varchar NULL,
	"CURR" varchar NULL,
	"CATG" varchar NULL,
	"CONT_DATE" varchar NULL,
	"VAL_DATE" varchar NULL,
	"MATR_DATE" varchar NULL,
	"LIMT_REF" varchar NULL,
	"COMP" varchar NULL,
	"ACCT_OFFC" varchar NULL,
	"INTR_KEY" varchar NULL,
	"TIEG" varchar NULL,
	"INTR_SPREAD" varchar NULL,
	"TAUX_BASE" varchar NULL,
	"MARG" varchar NULL,
	"INTR_RATE" varchar NULL,
	"TYPE_ENG" varchar NULL,
	"REF_TITR_CR" varchar NULL,
	"MONT_DEBL" varchar NULL,
	"CDRCUST" int4 NULL,
	"CDRCODENG" int4 NOT NULL,
	"CDRCURR" int4 NULL,
	"CDR_TITR" int4 NOT NULL,
	"CDRCATG" int4 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_CONTRAT_pkey" PRIMARY KEY ("REF_CONT", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_CONTRAT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_CONTRAT" TO postgres;


-- public."E_CONTRAT_PERSO_BIAT" definition

-- Drop table

-- DROP TABLE public."E_CONTRAT_PERSO_BIAT";

CREATE TABLE public."E_CONTRAT_PERSO_BIAT" (
	"CDRCONTRH" int4 NOT NULL,
	"REF_CONT" varchar(20) NOT NULL,
	"CODE_ENGG" varchar(10) NULL,
	"COMP_CTOS" varchar(10) NULL,
	"PRSN_NOM" varchar(100) NULL,
	"DATE_DEBL" int4 NULL,
	"MONT_DEBL" float4 NULL,
	"MNT_PPL_ECH" float4 NULL,
	"MNT_INT_ECH" float4 NULL,
	"DATE_DEBT_REMB" int4 NULL,
	"MATR_DATE" int4 NULL,
	"TAUX_INTR" float4 NULL,
	"TAUX_INTR_WR" float4 NULL,
	"INTR_BASS" varchar(3) NULL,
	"RANG_CREDT" int4 NULL,
	"NBRE" int4 NULL,
	"REF_TITR_CR" varchar(20) NULL,
	"COMP" varchar NULL,
	"CODE_CLNT" varchar NULL,
	"MATR" varchar NULL,
	"LIMT_REF" varchar NULL,
	"CURR" varchar NULL,
	"CATG" varchar NULL,
	"CDRCUST" int4 NULL,
	"CDRCODENGRH" int4 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" int4 NOT NULL,
	CONSTRAINT "E_CONTRAT_PERSO_BIAT_pkey" PRIMARY KEY ("CDRCONTRH", "REF_CONT", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_CONTRAT_PERSO_BIAT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_CONTRAT_PERSO_BIAT" TO postgres;


-- public."E_CURRENCY" definition

-- Drop table

-- DROP TABLE public."E_CURRENCY";

CREATE TABLE public."E_CURRENCY" (
	"CDR_CURR" int4 NOT NULL,
	"ID" varchar(100) NOT NULL,
	"RANK" int4 NULL,
	"NUMR_CCY_CODE" int4 NULL,
	"INTR_DAY_BASS" varchar(100) NULL,
	"CONT_CODE" varchar(100) NULL,
	"REVL_RATE" varchar(16) NULL,
	"UNTE" varchar(4) NULL,
	"DESC" varchar(100) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	CONSTRAINT "E_CURRENCY_pkey" PRIMARY KEY ("CDR_CURR", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_CURRENCY" OWNER TO postgres;
GRANT ALL ON TABLE public."E_CURRENCY" TO postgres;


-- public."E_CUSTOMER" definition

-- Drop table

-- DROP TABLE public."E_CUSTOMER";

CREATE TABLE public."E_CUSTOMER" (
	"CDRCUST" int4 NOT NULL,
	"DATDEBVLD" int4 NOT NULL,
	"ACCN_OFFC" varchar(255) NULL,
	"AGRM" varchar(255) NULL,
	"ANNL_BONS" varchar(255) NULL,
	"BIRT_INCR_DATE" varchar(255) NULL,
	"CART_SEJR" varchar(255) NULL,
	"CDRACTV" int4 NULL,
	"CDRBIATPRFS" int4 NULL,
	"CDRINDS" int4 NULL,
	"CDRTARG" int4 NULL,
	"CIN" varchar(255) NULL,
	"CONT" varchar(255) NULL,
	"CONT_DATE" varchar(255) NULL,
	"CUST_CURR" varchar(255) NULL,
	"CUST_LIBL" varchar(255) NULL,
	"CUST_STTS" int4 NULL,
	"CUST_TYPE" varchar(255) NULL,
	"CU_ACTV" varchar(255) NULL,
	"CU_ANNE_CA" varchar(255) NULL,
	"CU_BLCK_LIST" varchar(255) NULL,
	"CU_CAPC_JUR" varchar(255) NULL,
	"CU_CAPT_SOCL" varchar(255) NULL,
	"CU_CHFF_AFFR" float4 NULL,
	"CU_CODE_BCT" varchar(255) NULL,
	"CU_CODE_SIT_JUR" int4 NULL,
	"CU_DATE_SIT_JUR" int4 NULL,
	"CU_DT_INTR_CHE" varchar(255) NULL,
	"CU_DT_TRAN_CNTX" int4 NULL,
	"CU_FORM_JUR" int4 NULL,
	"CU_GROP_AFFR" varchar(255) NULL,
	"CU_INTR_CART" varchar(255) NULL,
	"CU_INTR_CHQ" varchar(255) NULL,
	"CU_NB_EMPL" varchar(255) NULL,
	"CU_POLE_GEST" varchar(255) NULL,
	"CU_PRFS" varchar(255) NULL,
	"CU_PRSP_TRE" varchar(255) NULL,
	"CU_QULT" varchar(255) NULL,
	"CU_TYPE_ADRS" varchar(255) NULL,
	"DATCHG" int4 NULL,
	"DATE_AUT_BCT" int4 NULL,
	"DATE_EXPR_PASS" varchar(255) NULL,
	"DATE_OF_BIRTH" varchar(255) NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"EMAL_1" varchar(255) NULL,
	"EMPL_STTS" varchar(255) NULL,
	"EXNR_TVA" varchar(255) NULL,
	"FAMILY_NAME" varchar(255) NULL,
	"GEND" varchar(255) NULL,
	"GIVEN_NAMES" varchar(255) NULL,
	"ID" varchar(255) NULL,
	"IDNT_FISC" varchar(255) NULL,
	"IDNT_UNQ" varchar(255) NULL,
	"ID_BCT" varchar(255) NULL,
	"INDS" int4 NULL,
	"ISSU_CHQU" varchar(255) NULL,
	"JOB_TITL" varchar(255) NULL,
	"LANG" int4 NULL,
	"LEGL_EXP_DATE" int4 NULL,
	"MANL_RISK_CLSS" varchar(255) NULL,
	"MART_STTS" varchar(255) NULL,
	"MATR_FISC" varchar(255) NULL,
	"MNMN" varchar(255) NULL,
	"NAME_1" varchar(255) NULL,
	"NATN" varchar(255) NULL,
	"NET_MONT_IN" varchar(255) NULL,
	"NET_MONT_OUT" varchar(255) NULL,
	"NUMR_ANLT_CODE_PTT_GRFF" varchar(255) NULL,
	"NUM_BCT" varchar(255) NULL,
	"OTHR_NATN" varchar(255) NULL,
	"OTHR_OFFC" varchar(255) NULL,
	"OVRR_RESN" varchar(255) NULL,
	"PASS" varchar(255) NULL,
	"PATN" varchar(255) NULL,
	"PHNE_1" varchar(255) NULL,
	"POST_CODE" varchar(255) NULL,
	"POST_REST" int4 NULL,
	"RESD" varchar(255) NULL,
	"SALR" varchar(255) NULL,
	"SECT" varchar(255) NULL,
	"SHORT_NAME" varchar(255) NULL,
	"SMS_1" varchar(255) NULL,
	"SRC" varchar(255) NULL,
	"STRT" varchar(255) NULL,
	"TARG" int4 NULL,
	"TITL" varchar(255) NULL,
	"TOWN_CONT" varchar(255) NULL,
	"TYPE_ID_BCT" varchar(255) NULL,
	"VISA" varchar(255) NULL,
	CONSTRAINT "E_CUSTOMER_pkey" PRIMARY KEY ("CDRCUST", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_CUSTOMER" OWNER TO postgres;
GRANT ALL ON TABLE public."E_CUSTOMER" TO postgres;


-- public."E_CUSTOMER_RELATION" definition

-- Drop table

-- DROP TABLE public."E_CUSTOMER_RELATION";

CREATE TABLE public."E_CUSTOMER_RELATION" (
	"CDRCUST" int4 NOT NULL,
	"CDRRELTCUST" int4 NOT NULL,
	"ID" varchar(10) NOT NULL,
	"RELT_CUST" varchar(10) NOT NULL,
	"RELT_CODE" int4 NOT NULL,
	"REVR_REL_CODE" varchar(3) NULL,
	"CDRRELT" int4 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_CUSTOMER_RELATION_pkey" PRIMARY KEY ("ID", "RELT_CUST", "RELT_CODE", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_CUSTOMER_RELATION" OWNER TO postgres;
GRANT ALL ON TABLE public."E_CUSTOMER_RELATION" TO postgres;


-- public."E_DRAWINGS" definition

-- Drop table

-- DROP TABLE public."E_DRAWINGS";

CREATE TABLE public."E_DRAWINGS" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar(200) NOT NULL,
	"DRWN_TYPE" varchar(200) NULL,
	"DRW_CURR" varchar(200) NULL,
	"DOCM_AMNT" float8 NULL,
	"VALU_DATE" int4 NULL,
	"DRWD_ACCNT" varchar(200) NULL,
	"PAMN_METH" varchar(200) NULL,
	"PAMN_ACCNT" varchar(200) NULL,
	"PAMN_AMNT" float8 NULL,
	"REMB_AMNT" float8 NULL,
	"LIMT_REFR" varchar(200) NULL,
	"DOC_AMT_LOCL" float8 NULL,
	"DOC_AMT_LC_CCY" float8 NULL,
	"FULL_UTLS" varchar(200) NULL,
	"LC_CRDT_TYPE" varchar(200) NULL,
	"CUST_LINK" varchar(200) NULL,
	"PROV_AMT_REL" varchar(19) NULL,
	"LC_LIAB_RELS" float8 NULL,
	"LC_LIAB_REL_LCY" float8 NULL,
	"REMB_AMT_LCCY" float8 NULL,
	"PAY_AMT_LCCY" float8 NULL,
	"PROV_REL_LC_CCY" float8 NULL,
	"PROV_REL_DOC_CCY" float8 NULL,
	"MATR_REVW" int4 NULL,
	"CHRG_CODE" varchar(200) NULL,
	"CHRG_CURR" varchar(200) NULL,
	"CHRG_AMNT" varchar(200) NULL,
	"RELTED_DRWN" varchar(200) NULL,
	"CHRG_LCCY_AMT" varchar(200) NULL,
	"TYP_ENG" varchar(200) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NULL,
	CONSTRAINT "E_DRAWINGS_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_DRAWINGS" OWNER TO postgres;
GRANT ALL ON TABLE public."E_DRAWINGS" TO postgres;


-- public."E_ENCOURS" definition

-- Drop table

-- DROP TABLE public."E_ENCOURS";

CREATE TABLE public."E_ENCOURS" (
	"CDRCONTMUTL" int4 NOT NULL,
	"REF_CONT" varchar(15) NOT NULL,
	"MONT_ENCR_INTL_TND" numeric(15,3) NULL,
	"MONT_ENCR_REDR_TND" numeric(15,3) NULL,
	"MONT_ENCR_INTL_DEV" numeric(15,3) NULL,
	"MONT_ENCR_REDR_DEV" numeric(15,3) NULL,
	"CODE_TYP_ENCR" int4 NOT NULL,
	"STATUT" bpchar(1) NOT NULL,
	"CDR_TYP_ENCR" int4 NULL,
	"DAT_SIT" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" varchar(20) NOT NULL,
	CONSTRAINT "E_ENCOURS_pkey" PRIMARY KEY ("REF_CONT", "CODE_TYP_ENCR", "STATUT", "DAT_SIT", "DAT_CHG")
);

-- Permissions

ALTER TABLE public."E_ENCOURS" OWNER TO postgres;
GRANT ALL ON TABLE public."E_ENCOURS" TO postgres;


-- public."E_ENCOURS_PERSO_BIAT" definition

-- Drop table

-- DROP TABLE public."E_ENCOURS_PERSO_BIAT";

CREATE TABLE public."E_ENCOURS_PERSO_BIAT" (
	"CDRCONTRH" int4 NOT NULL,
	"REF_CONT" varchar(15) NOT NULL,
	"MONT_ENCR_INTL" numeric(15,3) NULL,
	"MONT_ENCR" numeric(15,3) NULL,
	"MONT_ENCR_TND" numeric(15,3) NULL,
	"CODE_TYP_ENCR" int4 NOT NULL,
	"STATUT" varchar(1) NOT NULL,
	"DAT_SIT" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" varchar(20) NOT NULL,
	cdrcontmutl int4 NULL,
	CONSTRAINT "E_ENCOURS_PERSO_BIAT_pkey" PRIMARY KEY ("CDRCONTRH", "REF_CONT", "CODE_TYP_ENCR", "STATUT", "DAT_SIT", "DAT_CHG")
);

-- Permissions

ALTER TABLE public."E_ENCOURS_PERSO_BIAT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_ENCOURS_PERSO_BIAT" TO postgres;


-- public."E_LC" definition

-- Drop table

-- DROP TABLE public."E_LC";

CREATE TABLE public."E_LC" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar NOT NULL,
	"CUST" varchar NULL,
	"CURR" varchar NULL,
	"ACCN" varchar NULL,
	"TYPE_ENG" varchar NULL,
	"ISSU_DATE" int4 NULL,
	"EXPR_DATE" int4 NULL,
	"OPRT" varchar NULL,
	"LC_TYPE" varchar NULL,
	"EXTR_REFR" varchar NULL,
	"CHRG_ACCN" varchar NULL,
	"LC_AMNT" float8 NULL,
	"DAY_BASS" varchar NULL,
	"CURR_MARK" varchar NULL,
	"POST_TYPE" varchar NULL,
	"LIMT_REFR" varchar NULL,
	"EXPR_PLAC" varchar NULL,
	"CLSN_DATE" int4 NULL,
	"BENF_CUST" varchar NULL,
	"CATG_CODE" varchar NULL,
	"ACCN_OFFC" varchar NULL,
	"LIBL_AMT" float8 NULL,
	"LC_AMNT_LOCL" float8 NULL,
	"DRWN" float8 NULL,
	"NEXT_DRWN" varchar NULL,
	"PAMN_AMT" float8 NULL,
	"APPL_CUST" varchar NULL,
	"APPL_ACC" varchar NULL,
	"FULLY_UTLS" varchar NULL,
	"PRVS_PERC" varchar NULL,
	"PRVS_AMNT" float8 NULL,
	"PRO_OUT_AMNT" float8 NULL,
	"PRO_AWAT_REL" float8 NULL,
	"PRVS_RATE" float8 NULL,
	"BENF" varchar NULL,
	"DRAW_TYPE" varchar NULL,
	"LIAB_PORT_AMT" float8 NULL,
	"LCY_PORT_AMT" float8 NULL,
	"LR_EFF_AVAL" varchar NULL,
	"LR_REF_AVAL" varchar NULL,
	"NUMR_COMP" varchar NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_LC_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_LC" OWNER TO postgres;
GRANT ALL ON TABLE public."E_LC" TO postgres;


-- public."E_LD" definition

-- Drop table

-- DROP TABLE public."E_LD";

CREATE TABLE public."E_LD" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar(200) NOT NULL,
	"CUST_ID" varchar(200) NULL,
	"CURR" varchar(200) NULL,
	"VALU_DATE" int4 NULL,
	"FIN_MAT_DATE" int4 NULL,
	"LIMT_REFR" varchar(200) NULL,
	"CATG" varchar(200) NULL,
	"DRWD_ACCN" varchar(200) NULL,
	"INT_RATE_TYPE" varchar(200) NULL,
	"INTR_BASI" varchar(200) NULL,
	"INT_PAMT_METH" varchar(200) NULL,
	"INTR_KEY" varchar(200) NULL,
	"INTR_SPRD" float4 NULL,
	"ACCR_PARM" varchar(200) NULL,
	"LIQU_MODE" varchar(200) NULL,
	"OVRD_STTS" varchar(200) NULL,
	"GRAC_PERD" varchar(200) NULL,
	"GRAC_AMNT" varchar(200) NULL,
	"PRIN_LIQ_ACCT" varchar(200) NULL,
	"INT_LIQ_ACCT" varchar(200) NULL,
	"CHRG_LIQ_ACCT" varchar(200) NULL,
	"MIS_ACCT_OFFC" varchar(200) NULL,
	"AGRM_DATE" int4 NULL,
	"CONR_RISK" varchar(200) NULL,
	"CONT_EXPS" varchar(200) NULL,
	"STTS" varchar(200) NULL,
	"DRWD_ISSU_PRC" float4 NULL,
	"DRWD_NET_AMT" float4 NULL,
	"REMB_AMNT" float4 NULL,
	"FEE_PAY_ACCNT" varchar(200) NULL,
	"AMNT_INCR" varchar(200) NULL,
	"NEW_SPRD" varchar(200) NULL,
	"SPRD_V_DATE" varchar(200) NULL,
	"DRWD_ENT_DATE" int4 NULL,
	"CO_CODE" varchar(200) NULL,
	"A_PRRG" varchar(35) NULL,
	"A_RENV" varchar(15) NULL,
	"BANQ_TIRE" varchar(10) NULL,
	"BILL_NUMB" varchar(12) NULL,
	"CHRG_AMNT" varchar(10) NULL,
	"CHRG_BOKD_ON" int4 NULL,
	"CHRG_CPTL" varchar(35) NULL,
	"CHRG_CLM_DATE" int4 NULL,
	"CHRG_CODE" varchar(3) NULL,
	"CLE_TAUX_BASE" int4 NULL,
	"CONT_MARC" varchar(18) NULL,
	"DURE_CRDT" float4 NULL,
	"ENCR_INTL" float4 NULL,
	"INTR_RATE" float4 NULL,
	"LD_INTR_NET" float4 NULL,
	"LD_MARG" float4 NULL,
	"LD_MARG_INIT" float4 NULL,
	"LD_NANT" varchar(35) NULL,
	"LIB_TYPE_ENG" varchar(100) NULL,
	"MARG" float4 NULL,
	"NIV_DELG_MAX" varchar(35) NULL,
	"NOM_TIRE" varchar(100) NULL,
	"OUR_REMR" varchar(35) NULL,
	"REF_MARC" varchar(15) NULL,
	"REF_TITR_CRDT" varchar(35) NULL,
	"RIB_TIRE" varchar(35) NULL,
	"TAUX_BASE" float4 NULL,
	"TAUX_GLBL" float4 NULL,
	"TIEG" float4 NULL,
	"TIEX" float4 NULL,
	"TITR" varchar(35) NULL,
	"TYPE_CRDT" varchar(35) NULL,
	"TYPE_ENG" varchar(35) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_LD_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_LD" OWNER TO postgres;
GRANT ALL ON TABLE public."E_LD" TO postgres;


-- public."E_MD" definition

-- Drop table

-- DROP TABLE public."E_MD";

CREATE TABLE public."E_MD" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar(17) NOT NULL,
	"CURR" varchar(3) NULL,
	"CUST" varchar(10) NULL,
	"TYP_ENG" varchar(35) NULL,
	"ACCN" varchar(35) NULL,
	"VALU_DATE" varchar(11) NULL,
	"MATR_DATE" varchar(11) NULL,
	"EPS_MONT_INI" varchar NULL,
	"CCY_MARK" varchar NULL,
	"PRNC_AMNT" varchar NULL,
	"DEAL_DATE" varchar NULL,
	"CONT_TYPE" varchar NULL,
	"DEAL_SUB_TYPE" varchar NULL,
	"CATG" varchar NULL,
	"LIMT_UPD_REQD" varchar NULL,
	"LIMT_REFR" varchar NULL,
	"ACCN_OFFC" varchar NULL,
	"CONT_RISK" varchar NULL,
	"CONT_EXPS" varchar NULL,
	"LIMT_AMNT" varchar NULL,
	"STTS" varchar NULL,
	"NET_PRIN_AMNT" varchar NULL,
	"INCL_PRVS" varchar NULL,
	"PRVS" varchar NULL,
	"PROV_DR_ACCNT" varchar NULL,
	"PROV_PERC" varchar NULL,
	"PROV_AMNT" varchar NULL,
	"PROV_REL_DATE" int4 NULL,
	"PROV_REL_ACCN" varchar NULL,
	"AUTO_EXPR" varchar NULL,
	"ALTR_ID" varchar NULL,
	"LIQD_MODE" varchar NULL,
	"CHRG_DATE" varchar NULL,
	"CHRG_CURR" varchar NULL,
	"CHRG_ACCN" varchar NULL,
	"TAX_CODE" varchar NULL,
	"BEN_ADDR" varchar NULL,
	"EPS_REF_MARC" varchar NULL,
	"EPS_MOTF_APUR" varchar NULL,
	"EPS_MODF" varchar NULL,
	"EPS_ECH_INTL" int4 NULL,
	"EPS_TYPE_DOC" varchar NULL,
	"EPS_DELV" varchar NULL,
	"EPS_AVIS_MJEU" varchar NULL,
	"EPS_CAUT_MODL" varchar NULL,
	"EPS_RECP" varchar NULL,
	"EPS_DELV_REMP" varchar NULL,
	"EPS_DT_RECP_MJ" int4 NULL,
	"EPS_PIST_CMC7" varchar NULL,
	"EPS_MONTN_EFF" varchar NULL,
	"EPS_ECH_EFFT" int4 NULL,
	"EPS_RIB_DEST" varchar NULL,
	"EPS_PAMN_MJ" varchar NULL,
	"EPS_DEST" varchar NULL,
	"EPS_DT_REMS_C" int4 NULL,
	"EPS_NBJR_VALI" int4 NULL,
	"EPS_PORC_CD" int4 NULL,
	"EPS_MOTF_ANNL" varchar NULL,
	"EPS_CONT_MAR" varchar NULL,
	"EPS_ACCN" varchar NULL,
	"MIGR" varchar NULL,
	"NIV_DELG_MAX" varchar NULL,
	"EPS_VALD" varchar NULL,
	"EPS_MODL" varchar NULL,
	"EPS_APR_PART" varchar NULL,
	"EPS_APR_ECH_AUT" varchar NULL,
	"EPS_MOIS_INDV" varchar NULL,
	"LIB_TYPE_ENG" varchar NULL,
	"EPS_TEMP_INV" float8 NULL,
	"EPS_TEMP_PROV" float8 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_MD_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_MD" OWNER TO postgres;
GRANT ALL ON TABLE public."E_MD" TO postgres;


-- public."E_MG" definition

-- Drop table

-- DROP TABLE public."E_MG";

CREATE TABLE public."E_MG" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar NOT NULL,
	"CUST" varchar NULL,
	"CONT_TYP" varchar NULL,
	"CONT_STTS" varchar NULL,
	"CURR" varchar NULL,
	"PRNC_AMNT" float8 NULL,
	"CATG" varchar NULL,
	"CONT_DATE" int4 NULL,
	"VAL_DATE" int4 NULL,
	"TERM" float4 NULL,
	"ORGN_MAT_DATE" int4 NULL,
	"MATR_DATE" int4 NULL,
	"INTR_BASS" varchar NULL,
	"EFFC_INT" varchar NULL,
	"REPM_DATE" varchar(19) NULL,
	"REDM_DATE" varchar NULL,
	"REDM_STRT_DATE" int4 NULL,
	"REPM_AMNT" float8 NULL,
	"THRT_AMNT" float8 NULL,
	"LIQU_MODE" varchar NULL,
	"OVRD_STTS" varchar NULL,
	"LIMT_REF" varchar NULL,
	"MORT_ACCN" varchar NULL,
	"DRWD_ACCN" varchar NULL,
	"TOTL_CHRG" float8 NULL,
	"TOTL_CHG_TAX" float8 NULL,
	"MIS_ACCT_OFFC" varchar NULL,
	"INTL_RATE" float8 NULL,
	"INT_LIQ_ACCT" varchar NULL,
	"CO_CODE" varchar NULL,
	"MG_TIEX" float8 NULL,
	"INTR_KEY" varchar NULL,
	"MG_REF_CONV" varchar NULL,
	"PAMN_TYPE" varchar NULL,
	"FIXD_VAR_IND" varchar NULL,
	"MG_TIEG" float8 NULL,
	"MG_REF_VERS" varchar NULL,
	"DETL_BESN" varchar NULL,
	"NIV_DELG_MAX" varchar NULL,
	"MG_REF_DEMN" varchar NULL,
	"MG_REF_BESN" varchar NULL,
	"OUR_REMR" varchar NULL,
	"TYPE_CREDT" varchar NULL,
	"INTR_SPRD" float8 NULL,
	"MG_TAUX_BASE" float8 NULL,
	"MG_MARG" float4 NULL,
	"CHRG_TAX_LCY" varchar NULL,
	"CHRG_CODE" varchar NULL,
	"CHRG_DATE" varchar NULL,
	"INTR_RATE" float8 NULL,
	"CHRG_CCY" varchar NULL,
	"CHRG_AMNT" varchar NULL,
	"CHRG_ACCN" varchar NULL,
	"TYPE_ENG" varchar NULL,
	"MG_REF_TITR_CR" varchar NULL,
	"CHRG_AMT_LCY" varchar NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_MG_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_MG" OWNER TO postgres;
GRANT ALL ON TABLE public."E_MG" TO postgres;


-- public."E_PD" definition

-- Drop table

-- DROP TABLE public."E_PD";

CREATE TABLE public."E_PD" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar NOT NULL,
	"CUSTOMER" varchar NULL,
	"CURRENCY" varchar NULL,
	"CURRENCY_MARKET" varchar NULL,
	"POSITION_TYPE" varchar NULL,
	"ACCOUNT_OFFICER" varchar NULL,
	"CATEGORY" varchar NULL,
	"INTEREST_BASIS" varchar NULL,
	"PENALTY_RATE" varchar NULL,
	"PENALTY_KEY" varchar NULL,
	"PENALTY_SPREAD" varchar NULL,
	"PARAMETER_RECORD" varchar NULL,
	"ORIG_LIMIT_REF" varchar NULL,
	"LIMIT_REFERENCE" varchar NULL,
	"FINAL_DUE_DATE" varchar NULL,
	"REPAYMENT_ACCT" varchar NULL,
	"START_DATE" varchar NULL,
	"CO_CODE" varchar NULL,
	"ACCRUAL_PARAM" varchar NULL,
	"ROUNDING_RULE" varchar NULL,
	"WAIVE_GRA_PE" varchar NULL,
	"WAIVE_GRA_PS" varchar NULL,
	"ORIG_STLMNT_ACT" varchar NULL,
	"REPAID_STATUS" varchar NULL,
	"TYPE_CREDIT" varchar NULL,
	"TYPE_ENG" varchar NULL,
	"LIB_TYPE_ENG" varchar NULL,
	"PRIORITE_IMPAYE" varchar NULL,
	"INTERVALLE_IMP" varchar NULL,
	"ENV_RECOUV_EXT" varchar NULL,
	"TYPE_RECOUV_EXT" varchar NULL,
	"RS_RECOUV_EXT" varchar NULL,
	"DOC_RECOUV_EXT" varchar NULL,
	"NAT_DOC_RECOUV" varchar NULL,
	"REFERENCE" varchar NULL,
	"COMPTE" varchar NULL,
	"COURS_CHANGE" varchar NULL,
	"LC_NUMBER_12" varchar NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_PD_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_PD" OWNER TO postgres;
GRANT ALL ON TABLE public."E_PD" TO postgres;


-- public."E_PD_DETAIL" definition

-- Drop table

-- DROP TABLE public."E_PD_DETAIL";

CREATE TABLE public."E_PD_DETAIL" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar(35) NOT NULL,
	"DAT_ECHN" varchar(8) NULL,
	"REF_CONT" varchar(14) NULL,
	"ANCN" varchar(8) NULL,
	"MONT_PRNC_INTL" varchar(30) NULL,
	"MONT_PRNC_INTL_RED" varchar(30) NULL,
	"MONT_PRNC_INTL_TND" varchar(30) NULL,
	"MONT_PRNC_ACTL" varchar(30) NULL,
	"MONT_PRNC_ACTL_RED" varchar(30) NULL,
	"MONT_PRNC_ACTL_TND" varchar(30) NULL,
	"MONT_INTR_INTL" varchar(30) NULL,
	"MONT_INTR_INTL_RED" varchar(30) NULL,
	"MONT_INTR_INTL_TND" varchar(30) NULL,
	"MONT_INTR_ACTL" varchar(30) NULL,
	"MONT_INTR_ACTL_RED" varchar(30) NULL,
	"MONT_INTR_ACTL_TND" varchar(30) NULL,
	"MONT_INTR_RETR_1_INTL" varchar(30) NULL,
	"MONT_INTR_RETR_1_INTL_RED" varchar(30) NULL,
	"MONT_INTR_RETR_1_INTL_TND" varchar(30) NULL,
	"MONT_INTR_RETR_1_ACTL" varchar(30) NULL,
	"MONT_INTR_RETR_1_ACTL_RED" varchar(30) NULL,
	"MONT_INTR_RETR_1_ACTL_TND" varchar(30) NULL,
	"MONT_INTR_RETR_2_INTL" varchar(30) NULL,
	"MONT_INTR_RETR_2_INTL_RED" varchar(30) NULL,
	"MONT_INTR_RETR_2_INTL_TND" varchar(30) NULL,
	"MONT_INTR_RETR_2_ACTL" varchar(30) NULL,
	"MONT_INTR_RETR_2_ACTL_RED" varchar(30) NULL,
	"MONT_INTR_RETR_2_ACTL_TND" varchar(30) NULL,
	"MONT_WS_INTL" varchar(30) NULL,
	"MONT_WS_INTL_RED" varchar(30) NULL,
	"MONT_WS_INTL_TND" varchar(30) NULL,
	"MONT_WS_ACTL" varchar(30) NULL,
	"MONT_WS_ACTL_RED" varchar(30) NULL,
	"MONT_WS_ACTL_TND" varchar(30) NULL,
	"MONT_WE_INTL" varchar(30) NULL,
	"MONT_WE_INTL_RED" varchar(30) NULL,
	"MONT_WE_INTL_TND" varchar(30) NULL,
	"MONT_WE_ACTL" varchar(30) NULL,
	"MONT_WE_ACTL_RED" varchar(30) NULL,
	"MONT_WE_ACTL_TND" varchar(30) NULL,
	"DAT_SIT" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" varchar(20) NOT NULL,
	CONSTRAINT "E_PD_DETAIL_pkey" PRIMARY KEY ("ID", "DAT_SIT", "DATCHG")
);

-- Permissions

ALTER TABLE public."E_PD_DETAIL" OWNER TO postgres;
GRANT ALL ON TABLE public."E_PD_DETAIL" TO postgres;


-- public."E_PD_MONTANT" definition

-- Drop table

-- DROP TABLE public."E_PD_MONTANT";

CREATE TABLE public."E_PD_MONTANT" (
	"CDRCONTMUTL" int4 NOT NULL,
	"ID" varchar NOT NULL,
	"TOTAL_AMT_TO_REPAY" varchar NULL,
	"ANCIENNETE_IMP" varchar NULL,
	"INTERET" varchar NULL,
	"PRINCIPAL" varchar NULL,
	"PENALITE_RETARD_PS" varchar NULL,
	"PENALITE_RETARD_WE" varchar NULL,
	"PENALITE_RETARD_WS" varchar NULL,
	"PENALITE_RETARD_PE" varchar NULL,
	"MONTANT" varchar NULL,
	"DAT_SIT" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "E_PD_MONTANT_pkey" PRIMARY KEY ("ID", "DAT_SIT")
);

-- Permissions

ALTER TABLE public."E_PD_MONTANT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_PD_MONTANT" TO postgres;


-- public."E_TITRE_CREDIT" definition

-- Drop table

-- DROP TABLE public."E_TITRE_CREDIT";

CREATE TABLE public."E_TITRE_CREDIT" (
	"CDR_TITR" int4 NOT NULL,
	"REF_TITRE" varchar(200) NOT NULL,
	"REF_CREDIT" varchar(200) NULL,
	"DATE_GENR" varchar(200) NULL,
	"ORDRE_TRNC" varchar(200) NULL,
	"CODE_CLNT" varchar(200) NULL,
	"COM_CLNT" varchar(200) NULL,
	"ADRS_CLNT" varchar(200) NULL,
	"DOMC_BANC" varchar(200) NULL,
	"COMP_CLNT" varchar(200) NULL,
	"CPTE_CLT_CTOS" varchar(200) NULL,
	"RIB_CLNT" varchar(200) NULL,
	"CATG" varchar(200) NULL,
	"TYP_CRDT" varchar(200) NULL,
	"TYP_INTR" varchar(200) NULL,
	"DUREE" varchar(200) NULL,
	"DAT_SOSC" varchar(200) NULL,
	"LIEU_SOSC" varchar(200) NULL,
	"TAUX_CMP" varchar(200) NULL,
	"MONT_CMP" varchar(200) NULL,
	"TAUX_CETD" varchar(200) NULL,
	"MONT_CETD" varchar(200) NULL,
	"TAUX_COM_ENG" varchar(200) NULL,
	"TAUX_CONT_FNG" varchar(200) NULL,
	"TAUX_SOTUGAR" varchar(200) NULL,
	"MONT_DEBL" varchar(200) NULL,
	"TAUX_BASE" varchar(200) NULL,
	"MARG" varchar(200) NULL,
	"TAUX_APPL" varchar(200) NULL,
	"TIEG" varchar(200) NULL,
	"TAUX_CPG" varchar(200) NULL,
	"TAUX_CG" varchar(200) NULL,
	"MNT_TOT_INT" varchar(200) NULL,
	"TYPE_REMB" varchar(200) NULL,
	"DAT_DEBLC_THQ" varchar(200) NULL,
	"DAT_DEBLC_EFF" varchar(200) NULL,
	"DAT_SIGN_CNTR" varchar(200) NULL,
	"DAT_P_ECH_INT" varchar(200) NULL,
	"DAT_P_ECH_PPL" varchar(200) NULL,
	"PERDCT_PPL" varchar(200) NULL,
	"PERDCT_INT" varchar(200) NULL,
	"ANNTE" varchar(200) NULL,
	"NB_ECHN" varchar(200) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NULL,
	CONSTRAINT "E_TITRE_CREDIT_pkey" PRIMARY KEY ("CDR_TITR", "REF_TITRE", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_TITRE_CREDIT" OWNER TO postgres;
GRANT ALL ON TABLE public."E_TITRE_CREDIT" TO postgres;


-- public."E_TITRE_CREDIT_ECHEANCIER" definition

-- Drop table

-- DROP TABLE public."E_TITRE_CREDIT_ECHEANCIER";

CREATE TABLE public."E_TITRE_CREDIT_ECHEANCIER" (
	"CDR_TITR" int4 NULL,
	"REF_TITR" varchar(20) NOT NULL,
	"NUM_ECHN" int4 NOT NULL,
	"DATE_ECH" int4 NULL,
	"NB_JOURS_ECH" int4 NULL,
	"ENCR_ECH" numeric(15,3) NULL,
	"REF_CTOS_PPL" varchar(15) NULL,
	"MNT_PPL_ECH" numeric(15,3) NULL,
	"REF_CTOS_INT" varchar(15) NULL,
	"MNT_INT_ECH" numeric(15,3) NULL,
	"MNT_INT_COM_ECH" numeric(15,3) NULL,
	"MNT_TOT_ECH" numeric(15,3) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NULL,
	CONSTRAINT "E_TITRE_CREDIT_ECHEANCIER_pkey" PRIMARY KEY ("REF_TITR", "NUM_ECHN", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."E_TITRE_CREDIT_ECHEANCIER" OWNER TO postgres;
GRANT ALL ON TABLE public."E_TITRE_CREDIT_ECHEANCIER" TO postgres;


-- public."E_TITRE_CREDIT_ECHEANCIER_temp" definition

-- Drop table

-- DROP TABLE public."E_TITRE_CREDIT_ECHEANCIER_temp";

CREATE TABLE public."E_TITRE_CREDIT_ECHEANCIER_temp" (
	"ID" varchar NULL,
	"BLOC" varchar NULL,
	"CHAMP" varchar NULL,
	"VALEUR" varchar NULL,
	"DAT_SIT" int4 NULL,
	"DAT_CHG" int4 NULL,
	"DAT_CSO" int4 NULL
);

-- Permissions

ALTER TABLE public."E_TITRE_CREDIT_ECHEANCIER_temp" OWNER TO postgres;
GRANT ALL ON TABLE public."E_TITRE_CREDIT_ECHEANCIER_temp" TO postgres;


-- public."Functions" definition

-- Drop table

-- DROP TABLE public."Functions";

CREATE TABLE public."Functions" (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	query varchar(255) NULL,
	queryexcel varchar(255) NULL,
	status int4 NULL,
	creator varchar(255) NULL,
	CONSTRAINT "Functions_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Functions" OWNER TO postgres;
GRANT ALL ON TABLE public."Functions" TO postgres;


-- public."History" definition

-- Drop table

-- DROP TABLE public."History";

CREATE TABLE public."History" (
	id bigserial NOT NULL,
	actiontext varchar(255) NULL,
	actiontime timestamp NULL,
	actiontype varchar(255) NULL,
	CONSTRAINT "History_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."History" OWNER TO postgres;
GRANT ALL ON TABLE public."History" TO postgres;


-- public."LST" definition

-- Drop table

-- DROP TABLE public."LST";

CREATE TABLE public."LST" (
	periode varchar(255) NULL,
	unite varchar(255) NULL,
	eng_global float8 NULL,
	eng_ctx float8 NULL,
	eng_lease float8 NULL,
	mnt_rb_inf_20m float8 NULL,
	mnt_rb_inf_500 float8 NULL,
	pme_eng float8 NULL,
	prf_eng float8 NULL,
	par_eng float8 NULL,
	total_imp float8 NULL,
	mnt_imp_sup_90 float8 NULL,
	cre_rat_sup_90 float8 NULL,
	renov_eng float8 NULL,
	renov_imp float8 NULL,
	media_eng float8 NULL,
	media_imp float8 NULL,
	auto_eng float8 NULL,
	auto_imp float8 NULL,
	eng_par_hors_immo float8 NULL,
	imp_par_hors_immo float8 NULL,
	habitat_eng float8 NULL,
	habitat_imp float8 NULL,
	imp_prc float8 NULL,
	non_aut float8 NULL,
	dep float8 NULL,
	echu float8 NULL,
	cdl_nbr float8 NULL,
	cdl_mnt float8 NULL,
	cdl_inf_20m_nbr float8 NULL,
	cdl_inf_20m float8 NULL,
	cdl_inf_500_nbr float8 NULL,
	cdl_inf_500 float8 NULL,
	agios_res float8 NULL,
	prov_req float8 NULL,
	total_nbr_gen float8 NULL,
	total_gen float8 NULL,
	gen_inf_20_nbr float8 NULL,
	gen_inf_20 float8 NULL,
	ref_saine_nbr float8 NULL,
	ref_saine_mnt float8 NULL,
	ref_saine_inf_20_nbr float8 NULL,
	ref_saine_eng_inf_20 float8 NULL,
	ref_cdl_nbr float8 NULL,
	ref_cdl_mnt float8 NULL,
	nbr_rec float8 NULL,
	mnt_rec float8 NULL,
	par_nbr_gen float8 NULL,
	par_gen float8 NULL,
	par_ref_saine_nbr float8 NULL,
	par_ref_saine_mnt float8 NULL,
	par_ref_decouvert float8 NULL,
	ref_habit float8 NULL,
	ref_media float8 NULL,
	act_decouvert_nbr float8 NULL,
	act_decouvert float8 NULL,
	act_habit_nbr float8 NULL,
	act_habit float8 NULL,
	act_media_nbr float8 NULL,
	act_media float8 NULL,
	nbr_total float8 NULL,
	nbr_renouv float8 NULL,
	nbr_relation float8 NULL,
	nbr_bilan_saisie float8 NULL,
	cre_rat_sup_90_tot float8 NULL,
	decouvert float8 NULL,
	eng_inf_20 float8 NULL,
	cct_fiche float8 NULL,
	cct_enc float8 NULL,
	cct_nbr float8 NULL,
	cct_enc_saine float8 NULL,
	cmlt_fiche float8 NULL,
	cmlt_enc float8 NULL,
	cmlt_nbr float8 NULL,
	cmlt_enc_saine float8 NULL,
	debit float8 NULL,
	debit_gen_mnt float8 NULL,
	debit_gen_nbr float8 NULL,
	debit_enc_saine float8 NULL,
	par_dge float8 NULL,
	par_nbr_gen_dge float8 NULL,
	par_gen_dge float8 NULL,
	par_saine float8 NULL,
	engsig_y_imp float8 NULL,
	engsig_enc float8 NULL,
	engsig_nbr float8 NULL,
	engsig_enc_saine float8 NULL,
	gen_ctx_mnt float8 NULL,
	gen_ctx_nbr float8 NULL,
	mnt_ciar varchar(255) NULL,
	nbr_ciar varchar(255) NULL
);

-- Permissions

ALTER TABLE public."LST" OWNER TO postgres;
GRANT ALL ON TABLE public."LST" TO postgres;


-- public."Menu" definition

-- Drop table

-- DROP TABLE public."Menu";

CREATE TABLE public."Menu" (
	id bigserial NOT NULL,
	active bool NOT NULL,
	checked bool NOT NULL,
	iconcomponent varchar(255) NULL,
	idparent int8 NULL,
	"level" int4 NOT NULL,
	"name" varchar(255) NULL,
	url varchar(255) NULL,
	CONSTRAINT "Menu_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Menu" OWNER TO postgres;
GRANT ALL ON TABLE public."Menu" TO postgres;


-- public."Message" definition

-- Drop table

-- DROP TABLE public."Message";

CREATE TABLE public."Message" (
	id bigserial NOT NULL,
	codeclient varchar(255) NULL,
	compteclient varchar(255) NULL,
	idresponsemessage int8 NULL,
	"object" varchar(255) NULL,
	processstatus varchar(255) NULL,
	receiver varchar(255) NULL,
	sender varchar(255) NULL,
	status varchar(255) NULL,
	"text" varchar(255) NULL,
	"timestamp" timestamp NULL,
	"type" varchar(255) NULL,
	classe int4 NULL,
	motif varchar(255) NULL,
	url varchar(255) NULL,
	validation bool NULL,
	pre_classe int4 NULL,
	pre_motif varchar(255) NULL,
	CONSTRAINT "Message_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Message" OWNER TO postgres;
GRANT ALL ON TABLE public."Message" TO postgres;


-- public."P_TYP_ENG_BCT" definition

-- Drop table

-- DROP TABLE public."P_TYP_ENG_BCT";

CREATE TABLE public."P_TYP_ENG_BCT" (
	"TYPE_ENCR" varchar(50) NOT NULL,
	"TYPE_ENG" varchar(50) NOT NULL,
	"CODE_BCT" varchar(50) NOT NULL,
	"USG" varchar(50) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "P_TYP_ENG_BCT_pkey" PRIMARY KEY ("TYPE_ENCR", "TYPE_ENG", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."P_TYP_ENG_BCT" OWNER TO postgres;
GRANT ALL ON TABLE public."P_TYP_ENG_BCT" TO postgres;


-- public."Profile" definition

-- Drop table

-- DROP TABLE public."Profile";

CREATE TABLE public."Profile" (
	id bigserial NOT NULL,
	profiletype varchar(255) NULL,
	CONSTRAINT "Profile_pkey" PRIMARY KEY (id),
	CONSTRAINT uk_lnshvq7oeu6q45bkaglr96l4u UNIQUE (profiletype)
);

-- Permissions

ALTER TABLE public."Profile" OWNER TO postgres;
GRANT ALL ON TABLE public."Profile" TO postgres;


-- public."R_ACTIVITE" definition

-- Drop table

-- DROP TABLE public."R_ACTIVITE";

CREATE TABLE public."R_ACTIVITE" (
	"CDRACTV" int4 NOT NULL,
	"CDRCONTMUTL" int4 NULL,
	"ID" varchar(5) NOT NULL,
	"LIBL" varchar(200) NULL,
	"CORR_BCT" varchar(7) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_ACTIVITE_pkey" PRIMARY KEY ("CDRACTV", "ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_ACTIVITE" OWNER TO postgres;
GRANT ALL ON TABLE public."R_ACTIVITE" TO postgres;


-- public."R_BIAT_PROFESSION" definition

-- Drop table

-- DROP TABLE public."R_BIAT_PROFESSION";

CREATE TABLE public."R_BIAT_PROFESSION" (
	"CDRBIATPRFS" int4 NOT NULL,
	"ID" varchar(4) NOT NULL,
	"LIBL" varchar(75) NULL,
	"CORR_BCT" varchar(4) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" int4 NOT NULL,
	CONSTRAINT "R_BIAT_PROFESSION_pkey" PRIMARY KEY ("CDRBIATPRFS", "ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_BIAT_PROFESSION" OWNER TO postgres;
GRANT ALL ON TABLE public."R_BIAT_PROFESSION" TO postgres;


-- public."R_CATEGORY" definition

-- Drop table

-- DROP TABLE public."R_CATEGORY";

CREATE TABLE public."R_CATEGORY" (
	"CDRCATG" int4 NOT NULL,
	"ID" varchar(6) NOT NULL,
	"SYST_IND" varchar(3) NULL,
	"MNMN" varchar(10) NULL,
	"AC_CONT" varchar(35) NULL,
	"DESC" varchar(35) NULL,
	"SHRT_NAM" varchar(15) NULL,
	"LIGN_PRD" varchar(35) NULL,
	"TAXB" varchar(35) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_CATEGORY_pkey" PRIMARY KEY ("CDRCATG", "ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_CATEGORY" OWNER TO postgres;
GRANT ALL ON TABLE public."R_CATEGORY" TO postgres;


-- public."R_CODE_ENG" definition

-- Drop table

-- DROP TABLE public."R_CODE_ENG";

CREATE TABLE public."R_CODE_ENG" (
	"CDRCODENG" int4 NOT NULL,
	"ID" varchar(10) NOT NULL,
	"DESC" varchar(200) NULL,
	"CATG" varchar(35) NULL,
	"LIGN_PRDT" varchar(35) NULL,
	"PRIO_IMP" varchar(35) NULL,
	"DATE_DEBT" varchar(35) NULL,
	"DATE_FIN" varchar(35) NULL,
	"LIMT_REF" int4 NULL,
	"TYPE_LIMT" varchar(35) NULL,
	"DEVS" varchar(100000) NULL,
	"CATG_COMP" varchar(100000) NULL,
	"RECC_BIAT" varchar(15) NULL,
	"COD_ENG_BCT" varchar(4) NULL,
	"CDRCODENGBCT" int4 NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_CODE_ENG_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_CODE_ENG" OWNER TO postgres;
GRANT ALL ON TABLE public."R_CODE_ENG" TO postgres;


-- public."R_CODE_ENG_BCT" definition

-- Drop table

-- DROP TABLE public."R_CODE_ENG_BCT";

CREATE TABLE public."R_CODE_ENG_BCT" (
	"CDRCODENGBCT" int4 NOT NULL,
	"CODE_BCT" varchar(4) NOT NULL,
	"TYPE_CODE_BCT" int4 NOT NULL,
	"LIBELLE_LONG_CODE_BCT" varchar(200) NULL,
	"LIBELLE_COURT_CODE_BCT" varchar(100) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" int4 NOT NULL,
	CONSTRAINT "R_CODE_ENG_BCT_pkey" PRIMARY KEY ("CDRCODENGBCT", "CODE_BCT", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_CODE_ENG_BCT" OWNER TO postgres;
GRANT ALL ON TABLE public."R_CODE_ENG_BCT" TO postgres;


-- public."R_CODE_ENG_PERSO_BIAT" definition

-- Drop table

-- DROP TABLE public."R_CODE_ENG_PERSO_BIAT";

CREATE TABLE public."R_CODE_ENG_PERSO_BIAT" (
	"CDRCODENGRH" int4 NOT NULL,
	"CODE_ENGG" varchar(3) NOT NULL,
	"CODE_CRDT" varchar(3) NULL,
	"LIBL" varchar(100) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_CODE_ENG_PERSO_BIAT_pkey" PRIMARY KEY ("CDRCODENGRH", "CODE_ENGG", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_CODE_ENG_PERSO_BIAT" OWNER TO postgres;
GRANT ALL ON TABLE public."R_CODE_ENG_PERSO_BIAT" TO postgres;


-- public."R_INDUSTRY" definition

-- Drop table

-- DROP TABLE public."R_INDUSTRY";

CREATE TABLE public."R_INDUSTRY" (
	"CDRINDS" int4 NOT NULL,
	"ID" int4 NOT NULL,
	"DESC" varchar(100) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_INDUSTRY_pkey" PRIMARY KEY ("CDRINDS", "ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_INDUSTRY" OWNER TO postgres;
GRANT ALL ON TABLE public."R_INDUSTRY" TO postgres;


-- public."R_LIMITES" definition

-- Drop table

-- DROP TABLE public."R_LIMITES";

CREATE TABLE public."R_LIMITES" (
	"CDRLIMT" int4 NOT NULL,
	"ID" int4 NOT NULL,
	"DESC" varchar(35) NULL,
	"SHRT_NAM" varchar(15) NULL,
	"FX_OR_TIME_BAND" varchar(2) NULL,
	"REDC_LIMT" varchar(1) NULL,
	"LIMT_MNMN" varchar(4) NULL,
	"LIMT_KEY_TYP" varchar(7) NULL,
	"LIMT_PERC" varchar(3) NULL,
	"DEFL_CHCK" varchar(2) NULL,
	"PARN_REFR" varchar(7) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVAL" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" int4 NOT NULL,
	datfinvld int4 NULL,
	CONSTRAINT "R_LIMITES_pkey" PRIMARY KEY ("CDRLIMT", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_LIMITES" OWNER TO postgres;
GRANT ALL ON TABLE public."R_LIMITES" TO postgres;


-- public."R_RELATION" definition

-- Drop table

-- DROP TABLE public."R_RELATION";

CREATE TABLE public."R_RELATION" (
	"CDRRELT" int4 NOT NULL,
	"ID" int4 NOT NULL,
	"DESC" varchar NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_RELATION_pkey" PRIMARY KEY ("CDRRELT", "ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_RELATION" OWNER TO postgres;
GRANT ALL ON TABLE public."R_RELATION" TO postgres;


-- public."R_TARGET" definition

-- Drop table

-- DROP TABLE public."R_TARGET";

CREATE TABLE public."R_TARGET" (
	"CDRTARG" int4 NOT NULL,
	"ID" int4 NOT NULL,
	"DESC" varchar(35) NULL,
	"SHRT_NAM" varchar(100) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DAT_CHG" int4 NOT NULL,
	CONSTRAINT "R_TARGET_pkey" PRIMARY KEY ("CDRTARG", "ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_TARGET" OWNER TO postgres;
GRANT ALL ON TABLE public."R_TARGET" TO postgres;


-- public."R_TYPE_CREDIT" definition

-- Drop table

-- DROP TABLE public."R_TYPE_CREDIT";

CREATE TABLE public."R_TYPE_CREDIT" (
	"CDRCODENG" int4 NOT NULL,
	"ID" varchar(7) NOT NULL,
	"LIBL" varchar(200) NULL,
	"CATG" int4 NULL,
	"LIGN_PRDT" int4 NULL,
	"APPL" varchar(2) NULL,
	"LIMT_REF" int4 NULL,
	"PRIO_IMP" int4 NULL,
	"DATE_DEBT" int4 NULL,
	"DATE_FIN" int4 NULL,
	"TYPE_LIMT" varchar(3) NULL,
	"GEST_VERS" int4 NULL,
	"IND_STND" varchar(3) NULL,
	"ELEG_REFN" int4 NULL,
	"ELEG_TITR" int4 NULL,
	"ELEG_SOTGR" int4 NULL,
	"ELEG_FNG" int4 NULL,
	"ELEG_COF" int4 NULL,
	"RENV_PRRG" varchar(35) NULL,
	"CAT_TIEX" varchar(3) NULL,
	"CODE_KFCR" int4 NULL,
	"LIEN_EPRG" int4 NULL,
	"MONT_MIN" float8 NULL,
	"MONTT_MAX" float8 NULL,
	"MNT_NET_GLB_MAX" float8 NULL,
	"MNT_NET_MAX_TRX" float8 NULL,
	"TX_ENDT_MAX" float8 NULL,
	"REF_MARC" varchar(3) NULL,
	"REF_EXPR" varchar(3) NULL,
	"CLE_TX_BASE" varchar(4) NULL,
	"TYPE_DECM" varchar(4) NULL,
	"TYPE_INTR" varchar(8) NULL,
	"BASE_INTR" varchar(4) NULL,
	"MARG_STD" float4 NULL,
	"MARG_MIN" float4 NULL,
	"MARG_MAX" float4 NULL,
	"TAUX_MIN" float4 NULL,
	"TAUX_MAX" float4 NULL,
	"MARG_PENL" float4 NULL,
	"CHRG_CMP" varchar(35) NULL,
	"CHRG_ETD_ACR" varchar(35) NULL,
	"CHRG_ETD_REJ" varchar(35) NULL,
	"CHRG_RB_ANTC" varchar(35) NULL,
	"CHRG_REMB_ECH" varchar(35) NULL,
	"CHRG_COM_ENG" varchar(35) NULL,
	"COMM_PC" int4 NULL,
	"COMM_G" int4 NULL,
	"DURE_MIN" varchar(3) NULL,
	"DURE_MAX" varchar(4) NULL,
	"ECH_MAX" int4 NULL,
	"DURE_MAX_GB" varchar(5) NULL,
	"DEBL_TRNC" int4 NULL,
	"SUPP_MOB" varchar(35) NULL,
	"VALD_OFFR" varchar(3) NULL,
	"FRCH_MIN_THQ" varchar(3) NULL,
	"FRCH_MAX_THQ" varchar(3) NULL,
	"ANTC_DEBL_MAX" varchar(3) NULL,
	"VALD_TC" varchar(3) NULL,
	"FRCH_MIN_EFF" varchar(3) NULL,
	"LIEU_CONS_VM" varchar(20) NULL,
	"RECC_IMP_BIAT" varchar(6) NULL,
	"TYPE_DEBL" varchar(6) NULL,
	"COMM_MISE_IMP" varchar(15) NULL,
	"RECR_STTS" varchar NULL,
	"CO_CODE" varchar NULL,
	"DEPT_CODE" varchar NULL,
	"DEVS" varchar(100000) NULL,
	"CATG_COMP" varchar(100000) NULL,
	"TYPE_REMB" varchar(9) NULL,
	"DATE_TIME" float8 NULL,
	"PER_REMB_PPL" varchar(500) NULL,
	"PER_REMB_INT" varchar(500) NULL,
	"OPTN_COMP" varchar(500) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_TYPE_CREDIT_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_TYPE_CREDIT" OWNER TO postgres;
GRANT ALL ON TABLE public."R_TYPE_CREDIT" TO postgres;


-- public."R_TYPE_ENCOUR" definition

-- Drop table

-- DROP TABLE public."R_TYPE_ENCOUR";

CREATE TABLE public."R_TYPE_ENCOUR" (
	"CDR_TYP_ENCR" int4 NULL,
	"ID" int4 NOT NULL,
	"LIB_LONG" varchar(45) NULL,
	"LIB_CORT" varchar(15) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NULL,
	"DERSIT" int4 NULL,
	"DATCHG" int4 NULL,
	CONSTRAINT "R_TYPE_ENCOUR_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_TYPE_ENCOUR" OWNER TO postgres;
GRANT ALL ON TABLE public."R_TYPE_ENCOUR" TO postgres;


-- public."R_TYPE_ENG" definition

-- Drop table

-- DROP TABLE public."R_TYPE_ENG";

CREATE TABLE public."R_TYPE_ENG" (
	"CDRCODENG" int4 NOT NULL,
	"ID" varchar(10) NOT NULL,
	"LIBL" varchar(60) NULL,
	"FAML_PRCS" varchar(60) NULL,
	"LIGN_PRDT" varchar(60) NULL,
	"CATG" varchar(60) NULL,
	"LIMT_REF" int4 NULL,
	"TYPE_LIMT" varchar(60) NULL,
	"MODL_STD_MEP" varchar(60) NULL,
	"AUTR_DEVS" varchar(60) NULL,
	"DATE_DEBT" varchar(60) NULL,
	"DATE_FIN" varchar(60) NULL,
	"IND_STND" varchar(60) NULL,
	"LIEN_EPRG" varchar(60) NULL,
	"RECC_BIAT" int4 NULL,
	"ELEG_COF" varchar(60) NULL,
	"TABL_REFR" varchar(60) NULL,
	"TYPE_NOTF" varchar(60) NULL,
	"ETAP_NOTF" varchar(60) NULL,
	"DELS_NOTF" varchar(60) NULL,
	"RECR_STTS" varchar(4) NULL,
	"CURR_NO" int4 NULL,
	"DEPT_CODE" varchar(4) NULL,
	"DEVS" varchar(3) NULL,
	"DATE_TIME" float8 NULL,
	"DEVS_ENG" varchar(3) NULL,
	"TX_ENDT_MAX" varchar(60) NULL,
	"DEVS_TX" varchar(3) NULL,
	"REVN_MIN" varchar(60) NULL,
	"REVN_MAX" varchar(60) NULL,
	"CODE_KFCR" varchar(60) NULL,
	"SUPP_MOB" varchar(60) NULL,
	"LIEU_CONS_VM" varchar(60) NULL,
	"QUTT_FIN" varchar(60) NULL,
	"ELGB_TRE" varchar(60) NULL,
	"QUTT_FIN_TRE" varchar(60) NULL,
	"FRCH_THQ_INT" varchar(60) NULL,
	"MONT" varchar(60) NULL,
	"MNT_NET_GLB" varchar(60) NULL,
	"MNT_NET_TRX" varchar(60) NULL,
	"CAT_TIEX" varchar(60) NULL,
	"CLE_TX_BASE" varchar(60) NULL,
	"TYPE_DECM" varchar(60) NULL,
	"TYPE_INTR" varchar(60) NULL,
	"BASE_INTR" varchar(60) NULL,
	"MARG_STD" varchar(60) NULL,
	"MARG" varchar(60) NULL,
	"CHRG_CMP" varchar(60) NULL,
	"CHRG_ETD_ACR" varchar(60) NULL,
	"CHRG_ETD_REJ" varchar(60) NULL,
	"CHRG_RB_ANTC" varchar(60) NULL,
	"CHRG_REMB_ECH" varchar(60) NULL,
	"CHRG_COM_ENG" varchar(60) NULL,
	"COMM_PCG" varchar(60) NULL,
	"COMM_MISE_IMP" varchar(60) NULL,
	"TYPE_REMB" varchar(60) NULL,
	"DEBL_TRNC" varchar(60) NULL,
	"NBR_TRC" varchar(60) NULL,
	"PER_REMB_PPL" varchar(60) NULL,
	"PER_REMB_INT" varchar(60) NULL,
	"DURE" varchar(60) NULL,
	"VALD_OFFR" varchar(60) NULL,
	"PERD_LATN" varchar(60) NULL,
	"FRCH_THQ_PPL" varchar(60) NULL,
	"ANTC_DEBL" varchar(60) NULL,
	"VALD_TC" varchar(60) NULL,
	"ELEG_REFN" varchar(60) NULL,
	"ELEG_TITR" varchar(60) NULL,
	"ELEG_SOTG" varchar(60) NULL,
	"ELEG_FNG" varchar(60) NULL,
	"LIEN_PROM_IMMO" varchar(60) NULL,
	"CATG_COMP" varchar(60) NULL,
	"PRIO_IMP" varchar(60) NULL,
	"ELEG_DHMN" varchar(60) NULL,
	"CRD_AUTR_TYPE_TAUX" varchar(60) NULL,
	"TYPS_ENG_LIES" varchar(60) NULL,
	"MRG_B_FONDS" varchar(60) NULL,
	"ELEG_TUNS" varchar(60) NULL,
	"CALC_TUNS_CH" varchar(60) NULL,
	"METH_MEP" varchar(60) NULL,
	"EXEC_VIR_DEBL" varchar(60) NULL,
	"CPT_INTR_DEBL" varchar(60) NULL,
	"TAUX_EQUV" varchar(60) NULL,
	"CPT_INT_TRES_A_RECV" varchar(60) NULL,
	"CPT_PL_TRES_A_RECV" varchar(60) NULL,
	"CPT_INT_TRES_RECV" varchar(60) NULL,
	"CPT_INT_TRES_IMP" varchar(60) NULL,
	"CPT_PPL_IMP" varchar(60) NULL,
	"CPT_PPL_RECV" varchar(60) NULL,
	"INDIC_FOND_ETAT" varchar(60) NULL,
	"RAPP_GAR_CRD" varchar(60) NULL,
	"MNT_INV_MAX" varchar(60) NULL,
	"OPTN_COMP" varchar(60) NULL,
	"CPT_INT_RETR_TRES_A_RECV" varchar(60) NULL,
	"CPT_PL_INT_RETAR_TRES" varchar(60) NULL,
	"CPT_INT_RETR_RECV" varchar(60) NULL,
	"COMP_FOND" varchar(60) NULL,
	"ELIG_FGIC" varchar(60) NULL,
	"ELEG_SARE" varchar(60) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_TYPE_ENG_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_TYPE_ENG" OWNER TO postgres;
GRANT ALL ON TABLE public."R_TYPE_ENG" TO postgres;


-- public."R_TYPE_ENG_MD" definition

-- Drop table

-- DROP TABLE public."R_TYPE_ENG_MD";

CREATE TABLE public."R_TYPE_ENG_MD" (
	"CDRCODENG" int4 NOT NULL,
	"ID" varchar(7) NOT NULL,
	"DESC" varchar(60) NULL,
	"CATG" int4 NULL,
	"LIGN_PRDT" varchar(3) NULL,
	"PRIO_IMP" int4 NULL,
	"CODE_KFCR" varchar(4) NULL,
	"DATE_DEBUT" int4 NULL,
	"DATE_FIN" int4 NULL,
	"TYPE_LIMT" varchar(3) NULL,
	"TYPE_PRDT" varchar(10) NULL,
	"MODL" varchar(3) NULL,
	"APR_PART" varchar(3) NULL,
	"APR_ECH_AUT" varchar(3) NULL,
	"LIMIT_REF" int4 NULL,
	"MOIS_INDV" varchar(3) NULL,
	"REF_MARC" varchar(3) NULL,
	"REF_CNTR_MARC" varchar(3) NULL,
	"TX_FINN" varchar(6) NULL,
	"COMM_RISQ" varchar(15) NULL,
	"PERD_COM_RISQ" varchar(15) NULL,
	"COMM_MEP_EPS" varchar(15) NULL,
	"COM_MODF_CLNT" varchar(15) NULL,
	"COMM_M_JEU" varchar(15) NULL,
	"RECC_BIAT" varchar(15) NULL,
	"RECR_STTS" varchar(4) NULL,
	"CO_CODE" varchar(40) NULL,
	"DEPT_CODE" varchar(10) NULL,
	"DEVS" varchar(1000) NULL,
	"CATG_COMP" varchar(1000) NULL,
	"COM_APRM" varchar(35) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_TYPE_ENG_MD_pkey" PRIMARY KEY ("ID", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_TYPE_ENG_MD" OWNER TO postgres;
GRANT ALL ON TABLE public."R_TYPE_ENG_MD" TO postgres;


-- public."R_UNITGEST" definition

-- Drop table

-- DROP TABLE public."R_UNITGEST";

CREATE TABLE public."R_UNITGEST" (
	"CDR_UNIT_GEST" int4 NOT NULL,
	"ID" varchar(20) NOT NULL,
	"AREA" varchar(20) NULL,
	"NAME" varchar(50) NULL,
	"TELEPHONE_NO" varchar(16) NULL,
	"RECORD_STATUS" varchar(3) NULL,
	"CO_CODE" varchar(35) NULL,
	"DEPT_LEVEL" varchar(15) NULL,
	"DEPT_PARENT" int4 NULL,
	"CODE_AGENCE" varchar(11) NULL,
	"CODE_AGENCE_BCT" varchar(20) NULL,
	"CODE_AGENCE_RIB" varchar(100) NULL,
	"CODE_COMPANY" varchar(100) NULL,
	"ATQ_WU" varchar(11) NULL,
	"LR_LONGITUDE" varchar(20) NULL,
	"LR_LATITUDE" varchar(20) NULL,
	"LR_GOUVERNERAT" varchar(35) NULL,
	"TYPE_AGENCE" varchar(50) NULL,
	"CLSS" varchar(50) NULL,
	"DATE_OUVT" varchar(16) NULL,
	"DATDEBVLD" int4 NOT NULL,
	"DATFINVLD" int4 NOT NULL,
	"DERSIT" int4 NOT NULL,
	"DATCHG" int4 NOT NULL,
	CONSTRAINT "R_UNITGEST_pkey" PRIMARY KEY ("CDR_UNIT_GEST", "DATDEBVLD")
);

-- Permissions

ALTER TABLE public."R_UNITGEST" OWNER TO postgres;
GRANT ALL ON TABLE public."R_UNITGEST" TO postgres;


-- public."Tree" definition

-- Drop table

-- DROP TABLE public."Tree";

CREATE TABLE public."Tree" (
	id bigserial NOT NULL,
	agence varchar(255) NULL,
	pole varchar(255) NULL,
	region varchar(255) NULL,
	"zone" varchar(255) NULL,
	CONSTRAINT "Tree_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Tree" OWNER TO postgres;
GRANT ALL ON TABLE public."Tree" TO postgres;


-- public."Url" definition

-- Drop table

-- DROP TABLE public."Url";

CREATE TABLE public."Url" (
	id bigserial NOT NULL,
	component varchar(255) NULL,
	url varchar(255) NULL,
	CONSTRAINT "Url_pkey" PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public."Url" OWNER TO postgres;
GRANT ALL ON TABLE public."Url" TO postgres;


-- public.dwm_pd_payment_due_details definition

-- Drop table

-- DROP TABLE public.dwm_pd_payment_due_details;

CREATE TABLE public.dwm_pd_payment_due_details (
	s varchar(255) NOT NULL,
	cpte varchar(255) NULL,
	cpte_24 varchar(255) NULL,
	currency varchar(255) NULL,
	customer varchar(255) NULL,
	date_ech varchar(255) NULL,
	id varchar(255) NULL,
	imp_int varchar(255) NULL,
	imp_int_os varchar(255) NULL,
	imp_int_penalit varchar(255) NULL,
	imp_int_penalit_os varchar(255) NULL,
	imp_int_retard varchar(255) NULL,
	imp_int_retard_os varchar(255) NULL,
	imp_pr varchar(255) NULL,
	imp_pr_os varchar(255) NULL,
	lib_type_eng varchar(255) NULL,
	periode varchar(255) NULL,
	reference varchar(255) NULL,
	type_eng varchar(255) NULL,
	CONSTRAINT dwm_pd_payment_due_details_pkey PRIMARY KEY (s)
);

-- Permissions

ALTER TABLE public.dwm_pd_payment_due_details OWNER TO postgres;
GRANT ALL ON TABLE public.dwm_pd_payment_due_details TO postgres;


-- public.risk_classe definition

-- Drop table

-- DROP TABLE public.risk_classe;

CREATE TABLE public.risk_classe (
	s varchar(255) NOT NULL,
	agios varchar(255) NULL,
	clascon varchar(255) NULL,
	clasgel varchar(255) NULL,
	clasimp varchar(255) NULL,
	clasmaxident varchar(255) NULL,
	classub varchar(255) NULL,
	cloture varchar(255) NULL,
	cpte varchar(255) NULL,
	datcloture varchar(255) NULL,
	ech_anc varchar(255) NULL,
	identif varchar(255) NULL,
	impinter varchar(255) NULL,
	impprinc varchar(255) NULL,
	mtf_con varchar(255) NULL,
	mtf_sub varchar(255) NULL,
	mvt varchar(255) NULL,
	periode varchar(255) NULL,
	soldcpte varchar(255) NULL,
	CONSTRAINT risk_classe_pkey PRIMARY KEY (s)
);

-- Permissions

ALTER TABLE public.risk_classe OWNER TO postgres;
GRANT ALL ON TABLE public.risk_classe TO postgres;


-- public.risk_cpte definition

-- Drop table

-- DROP TABLE public.risk_cpte;

CREATE TABLE public.risk_cpte (
	s varchar(255) NOT NULL,
	classe varchar(255) NULL,
	cpte varchar(255) NULL,
	graded varchar(255) NULL,
	motif varchar(255) NULL,
	periode varchar(255) NULL,
	risk_brut varchar(255) NULL,
	risk_net varchar(255) NULL,
	CONSTRAINT risk_cpte_pkey PRIMARY KEY (s)
);

-- Permissions

ALTER TABLE public.risk_cpte OWNER TO postgres;
GRANT ALL ON TABLE public.risk_cpte TO postgres;


-- public.tab1 definition

-- Drop table

-- DROP TABLE public.tab1;

CREATE TABLE public.tab1 (
	cpte varchar(255) NOT NULL,
	actfin int8 NULL,
	act_biat int8 NULL,
	agios_ech_int int8 NULL,
	agios_eff_imp int8 NULL,
	agios_eff_imp_deb int8 NULL,
	agios_res int8 NULL,
	agios_x int8 NULL,
	assur int8 NULL,
	avalbq int8 NULL,
	classe varchar(255) NULL,
	codrisk varchar(255) NULL,
	cotunace int8 NULL,
	depots int8 NULL,
	dont_cesur int8 NULL,
	ecart_prov int8 NULL,
	engsiga int8 NULL,
	engsigb int8 NULL,
	fng int8 NULL,
	garbq int8 NULL,
	garded int8 NULL,
	garetat int8 NULL,
	gar_even int8 NULL,
	hypo int8 NULL,
	idbct varchar(255) NULL,
	identif varchar(255) NULL,
	motif varchar(255) NULL,
	nom varchar(255) NULL,
	periode timestamp NULL,
	pod int8 NULL,
	prov_adit int8 NULL,
	prov_req int8 NULL,
	pro_cons int8 NULL,
	risk_brut int8 NULL,
	risk_net int8 NULL,
	solde_agios_deb_tri int8 NULL,
	typeidbct varchar(255) NULL,
	CONSTRAINT tab1_pkey PRIMARY KEY (cpte)
);

-- Permissions

ALTER TABLE public.tab1 OWNER TO postgres;
GRANT ALL ON TABLE public.tab1 TO postgres;


-- public.tab2 definition

-- Drop table

-- DROP TABLE public.tab2;

CREATE TABLE public.tab2 (
	cpte varchar(255) NOT NULL,
	agios int8 NULL,
	clascon varchar(255) NULL,
	clasgel varchar(255) NULL,
	clasimp varchar(255) NULL,
	clasmaxident varchar(255) NULL,
	classub varchar(255) NULL,
	cloture varchar(255) NULL,
	datcloture varchar(255) NULL,
	ech_anc varchar(255) NULL,
	identif varchar(255) NULL,
	impinter int8 NULL,
	impprinc int8 NULL,
	mtf_con varchar(255) NULL,
	mtf_sub varchar(255) NULL,
	mvt int8 NULL,
	periode timestamp NULL,
	soldcpte int8 NULL,
	CONSTRAINT tab2_pkey PRIMARY KEY (cpte)
);

-- Permissions

ALTER TABLE public.tab2 OWNER TO postgres;
GRANT ALL ON TABLE public.tab2 TO postgres;


-- public."Chat_messages" definition

-- Drop table

-- DROP TABLE public."Chat_messages";

CREATE TABLE public."Chat_messages" (
	"Chat_chat_id" int8 NOT NULL,
	messages_id int8 NOT NULL,
	CONSTRAINT uk_tf5eu6njojkamaviytdswgm4r UNIQUE (messages_id),
	CONSTRAINT fk4tdieqfmb4i99i47xbm20fnmk FOREIGN KEY ("Chat_chat_id") REFERENCES public."Chat"(chat_id),
	CONSTRAINT fkg90rnac3gm76g2k9sm59feh33 FOREIGN KEY (messages_id) REFERENCES public."Message"(id)
);

-- Permissions

ALTER TABLE public."Chat_messages" OWNER TO postgres;
GRANT ALL ON TABLE public."Chat_messages" TO postgres;


-- public."Classification" definition

-- Drop table

-- DROP TABLE public."Classification";

CREATE TABLE public."Classification" (
	id bigserial NOT NULL,
	classe int4 NULL,
	commentaire varchar(255) NULL,
	decision varchar(255) NULL,
	motif varchar(255) NULL,
	client_account varchar(255) NULL,
	CONSTRAINT "Classification_pkey" PRIMARY KEY (id),
	CONSTRAINT fk5y2hmstd9ps2ms1qc5i50iw1o FOREIGN KEY (client_account) REFERENCES public."Client"(account)
);

-- Permissions

ALTER TABLE public."Classification" OWNER TO postgres;
GRANT ALL ON TABLE public."Classification" TO postgres;


-- public."Classification_attachements" definition

-- Drop table

-- DROP TABLE public."Classification_attachements";

CREATE TABLE public."Classification_attachements" (
	"Classification_id" int8 NOT NULL,
	attachements_id int8 NOT NULL,
	CONSTRAINT uk_ml2cefoli5usr82nlx0ie57co UNIQUE (attachements_id),
	CONSTRAINT fknbg8d24okgu7px9sxqiin9mqo FOREIGN KEY (attachements_id) REFERENCES public."Attachement"(id),
	CONSTRAINT fkpfcjqxembi7d2o1f5x5ymn1oa FOREIGN KEY ("Classification_id") REFERENCES public."Classification"(id)
);

-- Permissions

ALTER TABLE public."Classification_attachements" OWNER TO postgres;
GRANT ALL ON TABLE public."Classification_attachements" TO postgres;


-- public."Menu_composants" definition

-- Drop table

-- DROP TABLE public."Menu_composants";

CREATE TABLE public."Menu_composants" (
	"Menu_id" int8 NOT NULL,
	composants_id int8 NOT NULL,
	CONSTRAINT uk_4s7xnuq31hy4s4rt9ab855m91 UNIQUE (composants_id),
	CONSTRAINT fk3i8404sucxq2fhy2qgj98bs32 FOREIGN KEY ("Menu_id") REFERENCES public."Menu"(id),
	CONSTRAINT fk3ioy73dssnefgcu9lsmae4uxm FOREIGN KEY (composants_id) REFERENCES public."Composant"(id)
);

-- Permissions

ALTER TABLE public."Menu_composants" OWNER TO postgres;
GRANT ALL ON TABLE public."Menu_composants" TO postgres;


-- public."Message_attachementReclamations" definition

-- Drop table

-- DROP TABLE public."Message_attachementReclamations";

CREATE TABLE public."Message_attachementReclamations" (
	"Message_id" int8 NOT NULL,
	"attachementReclamations_id" int8 NOT NULL,
	CONSTRAINT uk_7k4kx002la5nqu1x9of7oaal9 UNIQUE ("attachementReclamations_id"),
	CONSTRAINT fk1jowvexuh774p6q9a3lohvrbq FOREIGN KEY ("attachementReclamations_id") REFERENCES public."AttachementReclamation"(id),
	CONSTRAINT fkn0rv1plwjevh3bh9rorfsk6wn FOREIGN KEY ("Message_id") REFERENCES public."Message"(id)
);

-- Permissions

ALTER TABLE public."Message_attachementReclamations" OWNER TO postgres;
GRANT ALL ON TABLE public."Message_attachementReclamations" TO postgres;


-- public."Message_attachements" definition

-- Drop table

-- DROP TABLE public."Message_attachements";

CREATE TABLE public."Message_attachements" (
	"Message_id" int8 NOT NULL,
	attachements_id int8 NOT NULL,
	CONSTRAINT uk_ijnbeuhsbci60qac02i6wnyn7 UNIQUE (attachements_id),
	CONSTRAINT fkbjf5898toavmieoagbg19yhoe FOREIGN KEY (attachements_id) REFERENCES public."Attachement"(id),
	CONSTRAINT fkieh1ps4u6gh9i8pxv1a7my2oq FOREIGN KEY ("Message_id") REFERENCES public."Message"(id)
);

-- Permissions

ALTER TABLE public."Message_attachements" OWNER TO postgres;
GRANT ALL ON TABLE public."Message_attachements" TO postgres;


-- public."Permissions" definition

-- Drop table

-- DROP TABLE public."Permissions";

CREATE TABLE public."Permissions" (
	id bigserial NOT NULL,
	menu_id int8 NULL,
	CONSTRAINT "Permissions_pkey" PRIMARY KEY (id),
	CONSTRAINT fk1x8wp8tfim2xuvga4q2fk647f FOREIGN KEY (menu_id) REFERENCES public."Menu"(id)
);

-- Permissions

ALTER TABLE public."Permissions" OWNER TO postgres;
GRANT ALL ON TABLE public."Permissions" TO postgres;


-- public."Profile_permissions" definition

-- Drop table

-- DROP TABLE public."Profile_permissions";

CREATE TABLE public."Profile_permissions" (
	"Profile_id" int8 NOT NULL,
	permissions_id int8 NOT NULL,
	CONSTRAINT uk_odqprvyva63st6s7jdvu96x1m UNIQUE (permissions_id),
	CONSTRAINT fk6prjc03opw6tn97s3feu805r9 FOREIGN KEY ("Profile_id") REFERENCES public."Profile"(id),
	CONSTRAINT fkl6s931tws5bbxf0c76tud13k5 FOREIGN KEY (permissions_id) REFERENCES public."Permissions"(id)
);

-- Permissions

ALTER TABLE public."Profile_permissions" OWNER TO postgres;
GRANT ALL ON TABLE public."Profile_permissions" TO postgres;


-- public."Users" definition

-- Drop table

-- DROP TABLE public."Users";

CREATE TABLE public."Users" (
	id bigserial NOT NULL,
	libelle varchar(255) NULL,
	email varchar(255) NULL,
	lastlogout timestamp NULL,
	registerdate timestamp NULL,
	status varchar(255) NULL,
	userfirstname varchar(255) NULL,
	userlastname varchar(255) NULL,
	username varchar(255) NULL,
	userpassword varchar(255) NULL,
	profile varchar(255) NULL,
	initials varchar(255) NULL,
	CONSTRAINT "Users_pkey" PRIMARY KEY (id),
	CONSTRAINT fkn1glh7dob8uuu87gdhc4yndba FOREIGN KEY (profile) REFERENCES public."Profile"(profiletype)
);

-- Permissions

ALTER TABLE public."Users" OWNER TO postgres;
GRANT ALL ON TABLE public."Users" TO postgres;


-- public."Users_histories" definition

-- Drop table

-- DROP TABLE public."Users_histories";

CREATE TABLE public."Users_histories" (
	"User_id" int8 NOT NULL,
	histories_id int8 NOT NULL,
	CONSTRAINT uk_sgkw5wctf49c4eeyljh2ki9fv UNIQUE (histories_id),
	CONSTRAINT fk67y7d9hauiepvdn29fldmx3rw FOREIGN KEY (histories_id) REFERENCES public."History"(id),
	CONSTRAINT fk8ow1r8llrggtyrqcng6givrun FOREIGN KEY ("User_id") REFERENCES public."Users"(id)
);

-- Permissions

ALTER TABLE public."Users_histories" OWNER TO postgres;
GRANT ALL ON TABLE public."Users_histories" TO postgres;


-- public."Chat_users" definition

-- Drop table

-- DROP TABLE public."Chat_users";

CREATE TABLE public."Chat_users" (
	"Chat_chat_id" int8 NOT NULL,
	users_id int8 NOT NULL,
	CONSTRAINT uk_6cmecmd1uc3ek8c43rr24i9r4 UNIQUE (users_id),
	CONSTRAINT fkg8nufjattx9xwx5y4af2eu14n FOREIGN KEY ("Chat_chat_id") REFERENCES public."Chat"(chat_id),
	CONSTRAINT fkpvo8r5l7n83o8k6x7u1ae5vyl FOREIGN KEY (users_id) REFERENCES public."Users"(id)
);

-- Permissions

ALTER TABLE public."Chat_users" OWNER TO postgres;
GRANT ALL ON TABLE public."Chat_users" TO postgres;


-- public."DownloadPin" definition

-- Drop table

-- DROP TABLE public."DownloadPin";

CREATE TABLE public."DownloadPin" (
	id bigserial NOT NULL,
	createdat timestamp NULL,
	isvalidated bool NULL,
	pin varchar(255) NULL,
	user_id int8 NOT NULL,
	CONSTRAINT "DownloadPin_pkey" PRIMARY KEY (id),
	CONSTRAINT fk7tk4f66h9sxo151r4mle0m43m FOREIGN KEY (user_id) REFERENCES public."Users"(id)
);

-- Permissions

ALTER TABLE public."DownloadPin" OWNER TO postgres;
GRANT ALL ON TABLE public."DownloadPin" TO postgres;



CREATE OR REPLACE FUNCTION public.custom_month_name(integer)
 RETURNS text
 LANGUAGE sql
 IMMUTABLE
AS $function$

  SELECT CASE NULL

    WHEN 1 THEN 'janvier'

    WHEN 2 THEN 'février'

    WHEN 3 THEN 'mars'

    WHEN 4 THEN 'avril'

    WHEN 5 THEN 'mai'

    WHEN 6 THEN 'juin'

    WHEN 7 THEN 'juillet'

    WHEN 8 THEN 'août'

    WHEN 9 THEN 'septembre'

    WHEN 10 THEN 'octobre'

    WHEN 11 THEN 'novembre'

    WHEN 12 THEN 'décembre'

  END;

$function$
;

-- Permissions

ALTER FUNCTION public.custom_month_name(int4) OWNER TO postgres;
GRANT ALL ON FUNCTION public.custom_month_name(int4) TO postgres;


-- Permissions

GRANT ALL ON SCHEMA public TO postgres;
