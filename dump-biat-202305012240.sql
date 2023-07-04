--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2023-05-01 22:40:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3873 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 307 (class 1259 OID 149639)
-- Name: Attachement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Attachement" (
    id bigint NOT NULL,
    name character varying(255),
    path character varying(255),
    size character varying(255),
    type character varying(255)
);


ALTER TABLE public."Attachement" OWNER TO postgres;

--
-- TOC entry 306 (class 1259 OID 149638)
-- Name: Attachement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Attachement_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Attachement_id_seq" OWNER TO postgres;

--
-- TOC entry 3874 (class 0 OID 0)
-- Dependencies: 306
-- Name: Attachement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Attachement_id_seq" OWNED BY public."Attachement".id;


--
-- TOC entry 309 (class 1259 OID 157816)
-- Name: Chat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Chat" (
    chat_id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public."Chat" OWNER TO postgres;

--
-- TOC entry 308 (class 1259 OID 157815)
-- Name: Chat_chat_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Chat_chat_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Chat_chat_id_seq" OWNER TO postgres;

--
-- TOC entry 3875 (class 0 OID 0)
-- Dependencies: 308
-- Name: Chat_chat_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Chat_chat_id_seq" OWNED BY public."Chat".chat_id;


--
-- TOC entry 310 (class 1259 OID 157834)
-- Name: Chat_messages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Chat_messages" (
    "Chat_chat_id" bigint NOT NULL,
    messages_id bigint NOT NULL
);


ALTER TABLE public."Chat_messages" OWNER TO postgres;

--
-- TOC entry 311 (class 1259 OID 157837)
-- Name: Chat_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Chat_users" (
    "Chat_chat_id" bigint NOT NULL,
    users_id bigint NOT NULL
);


ALTER TABLE public."Chat_users" OWNER TO postgres;

--
-- TOC entry 318 (class 1259 OID 174688)
-- Name: Classification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Classification" (
    id bigint NOT NULL,
    classe integer,
    commentaire character varying(255),
    decision character varying(255),
    motif character varying(255),
    client_account character varying(255)
);


ALTER TABLE public."Classification" OWNER TO postgres;

--
-- TOC entry 319 (class 1259 OID 174696)
-- Name: Classification_attachements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Classification_attachements" (
    "Classification_id" bigint NOT NULL,
    attachements_id bigint NOT NULL
);


ALTER TABLE public."Classification_attachements" OWNER TO postgres;

--
-- TOC entry 317 (class 1259 OID 174687)
-- Name: Classification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Classification_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Classification_id_seq" OWNER TO postgres;

--
-- TOC entry 3876 (class 0 OID 0)
-- Dependencies: 317
-- Name: Classification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Classification_id_seq" OWNED BY public."Classification".id;


--
-- TOC entry 320 (class 1259 OID 174741)
-- Name: Client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Client" (
    account character varying(255) NOT NULL,
    code character varying(255),
    profile character varying(255),
    username character varying(255)
);


ALTER TABLE public."Client" OWNER TO postgres;

--
-- TOC entry 301 (class 1259 OID 125095)
-- Name: Composant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Composant" (
    id bigint NOT NULL,
    description character varying(255),
    query character varying(255),
    title character varying(255)
);


ALTER TABLE public."Composant" OWNER TO postgres;

--
-- TOC entry 300 (class 1259 OID 125094)
-- Name: Composant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Composant_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Composant_id_seq" OWNER TO postgres;

--
-- TOC entry 3877 (class 0 OID 0)
-- Dependencies: 300
-- Name: Composant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Composant_id_seq" OWNED BY public."Composant".id;


--
-- TOC entry 322 (class 1259 OID 184126)
-- Name: DownloadPin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."DownloadPin" (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    isvalidated boolean,
    pin character varying(255),
    user_id bigint NOT NULL
);


ALTER TABLE public."DownloadPin" OWNER TO postgres;

--
-- TOC entry 321 (class 1259 OID 184125)
-- Name: DownloadPin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."DownloadPin_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."DownloadPin_id_seq" OWNER TO postgres;

--
-- TOC entry 3878 (class 0 OID 0)
-- Dependencies: 321
-- Name: DownloadPin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."DownloadPin_id_seq" OWNED BY public."DownloadPin".id;


--
-- TOC entry 209 (class 1259 OID 58178)
-- Name: E_ACCOUNT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_ACCOUNT" (
    "CDRCONTMUTL" integer,
    "ID" character varying NOT NULL,
    "CUST" character varying,
    "CATG" character varying,
    "ACCN_TITL_1" character varying,
    "ACCN_TITL_2" character varying,
    "SHRT_TITL" character varying,
    "MNMN" character varying,
    "CURR" character varying,
    "LIMT_REF" character varying,
    "ACCN_OFFC" character varying,
    "POST_REST" character varying,
    "INTR_COMP_ACCT" character varying,
    "COND_GRP" character varying,
    "INCT_MARK" character varying,
    "OPNN_DATE" integer,
    "LINK_TO_LIMIT" character varying,
    "CLSR_DATE" integer,
    "CHRG_CCY" character varying,
    "CHRG_MKT" character varying,
    "INTR_CCY" character varying,
    "INTR_MKT" character varying,
    "ALL_NETT" character varying,
    "SING_LIMIT" character varying,
    "CLSD_ONLN" character varying,
    "CO_CODE" character varying,
    "RIB" character varying,
    "Comp_CTOS" character varying,
    "AUTR_MOTF_OUV" character varying,
    "CART_EPRG" character varying,
    "CU_AUTR_REST" character varying,
    "EMP_DEMR" character varying,
    "FORW_MVMT" character varying,
    "INT_LIQ_CCY" character varying,
    "INT_LIQU_ACCT" character varying,
    "MOTF_OUVR" character varying,
    "NATR_COMP" character varying,
    "NUM_LIVR" character varying,
    "OPT_SIGN" character varying,
    "OPTN_COMP" character varying,
    "OTHR_OFFC" character varying,
    "ACCT_CLSE_DATE" integer,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer,
    "DERSIT" integer,
    "DATCHG" integer
);


ALTER TABLE public."E_ACCOUNT" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 58185)
-- Name: E_ACCOUNT_PERSO_BIAT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_ACCOUNT_PERSO_BIAT" (
    "CDRCONTRH" integer,
    "ID" character varying NOT NULL,
    "CUST" character varying,
    "CATG" character varying,
    "ACCN_TITL_1" character varying,
    "ACCN_TITL_2" character varying,
    "SHRT_TITL" character varying,
    "MNMN" character varying,
    "CURR" character varying,
    "LIMT_REF" character varying,
    "ACCN_OFFC" character varying,
    "POST_REST" integer,
    "INTR_COMP_ACCT" character varying,
    "COND_GRP" character varying,
    "INCT_MARK" character varying,
    "OPNN_DATE" character varying,
    "LINK_TO_LIMIT" character varying,
    "CLSR_DATE" character varying,
    "CHRG_CCY" character varying,
    "CHRG_MKT" character varying,
    "INTR_CCY" character varying,
    "INTR_MKT" character varying,
    "ALLW_NETT" character varying,
    "SING_LIMIT" character varying,
    "CLSD_ONLN" character varying,
    "CO_CODE" character varying,
    "RIB" character varying,
    "Comp_CTOS" character varying,
    "AUTR_MOTF_OUV" character varying,
    "CART_EPRG" character varying,
    "CU_AUTR_REST" integer,
    "EMP_DEMR" character varying,
    "FORW_MVMT" character varying,
    "INT_LIQ_CCY" character varying,
    "INT_LIQU_ACCT" character varying,
    "MOTF_OUVR" character varying,
    "NATR_COMP" character varying,
    "NUM_LIVR" character varying,
    "OPT_SIGN" character varying,
    "OPTN_COMP" character varying,
    "OTHR_OFFC" character varying,
    "ACCT_CLSE_DATE" integer,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer,
    "DERSIT" integer,
    "DATCHG" integer
);


ALTER TABLE public."E_ACCOUNT_PERSO_BIAT" OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 58192)
-- Name: E_ACCOUNT_SOLDE; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_ACCOUNT_SOLDE" (
    "CDRCONTMUTL" integer,
    "ID" character varying(19) NOT NULL,
    "ACCR_CHG_AMNT" character varying(19),
    "ACCR_CHG_CATG" character varying(6),
    "ACCR_CR_AMNT" character varying(19),
    "ACCR_CR_CATG" character varying(6),
    "ACCR_DR_AMNT" character varying(19),
    "ACCR_DR_CATG" character varying(6),
    "OPEN_ACTL_BAL" character varying(19),
    "OPEN_CLRD_BAL" character varying(19),
    "ONLN_ACTL_BAL" character varying(19),
    "ONLN_CLRD_BAL" character varying(19),
    "WORK_BALN" character varying(19),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_ACCOUNT_SOLDE" OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 58197)
-- Name: E_ACCOUNT_SOLDE_PERSO_BIAT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_ACCOUNT_SOLDE_PERSO_BIAT" (
    "CDRCONTRH" integer,
    "ID" character varying(19) NOT NULL,
    "ACCR_CHG_AMNT" character varying(19),
    "ACCR_CHG_CATG" character varying(19),
    "ACCR_CR_AMNT" character varying(19),
    "ACCR_CR_CATG" character varying(19),
    "ACCR_DR_AMNT" character varying(19),
    "ACCR_DR_CATG" character varying(19),
    "OPEN_ACTUAL_BAL" character varying(19),
    "OPEN_CLEARED_BAL" character varying(19),
    "ONLINE_ACTUAL_BAL" character varying(19),
    "ONLINE_CLEARED_BAL" character varying(19),
    "WORKING_BALANCE" character varying(19),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_ACCOUNT_SOLDE_PERSO_BIAT" OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 58202)
-- Name: E_CONTRAT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_CONTRAT" (
    "CDRCONTMUTL" integer,
    "REF_CONT" character varying NOT NULL,
    "REF_CRDT" character varying NOT NULL,
    "CUST" character varying,
    "CURR" character varying,
    "CATG" character varying,
    "CONT_DATE" character varying,
    "VAL_DATE" character varying,
    "MATR_DATE" character varying,
    "LIMT_REF" character varying,
    "COMP" character varying,
    "ACCT_OFFC" character varying,
    "INTR_KEY" character varying,
    "TIEG" character varying,
    "INTR_SPREAD" character varying,
    "TAUX_BASE" character varying,
    "MARG" character varying,
    "INTR_RATE" character varying,
    "TYPE_ENG" character varying,
    "REF_TITR_CR" character varying,
    "MONT_DEBL" character varying,
    "CDRCUST" integer,
    "CDRCODENG" integer NOT NULL,
    "CDRCURR" integer,
    "CDR_TITR" integer NOT NULL,
    "CDRCATG" integer,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_CONTRAT" OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 58209)
-- Name: E_CONTRAT_PERSO_BIAT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_CONTRAT_PERSO_BIAT" (
    "CDRCONTRH" integer NOT NULL,
    "REF_CONT" character varying(20) NOT NULL,
    "CODE_ENGG" character varying(10),
    "COMP_CTOS" character varying(10),
    "PRSN_NOM" character varying(100),
    "DATE_DEBL" integer,
    "MONT_DEBL" real,
    "MNT_PPL_ECH" real,
    "MNT_INT_ECH" real,
    "DATE_DEBT_REMB" integer,
    "MATR_DATE" integer,
    "TAUX_INTR" real,
    "TAUX_INTR_WR" real,
    "INTR_BASS" character varying(3),
    "RANG_CREDT" integer,
    "NBRE" integer,
    "REF_TITR_CR" character varying(20),
    "COMP" character varying,
    "CODE_CLNT" character varying,
    "MATR" character varying,
    "LIMT_REF" character varying,
    "CURR" character varying,
    "CATG" character varying,
    "CDRCUST" integer,
    "CDRCODENGRH" integer,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" integer NOT NULL
);


ALTER TABLE public."E_CONTRAT_PERSO_BIAT" OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 58216)
-- Name: E_CURRENCY; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_CURRENCY" (
    "CDR_CURR" integer NOT NULL,
    "ID" character varying(100) NOT NULL,
    "RANK" integer,
    "NUMR_CCY_CODE" integer,
    "INTR_DAY_BASS" character varying(100),
    "CONT_CODE" character varying(100),
    "REVL_RATE" character varying(16),
    "UNTE" character varying(4),
    "DESC" character varying(100),
    "DATDEBVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL,
    "DATFINVLD" integer NOT NULL
);


ALTER TABLE public."E_CURRENCY" OWNER TO postgres;

--
-- TOC entry 283 (class 1259 OID 58981)
-- Name: E_CUSTOMER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_CUSTOMER" (
    "CDRCUST" integer NOT NULL,
    "DATDEBVLD" integer NOT NULL,
    "ACCN_OFFC" character varying(255),
    "AGRM" character varying(255),
    "ANNL_BONS" character varying(255),
    "BIRT_INCR_DATE" character varying(255),
    "CART_SEJR" character varying(255),
    "CDRACTV" integer,
    "CDRBIATPRFS" integer,
    "CDRINDS" integer,
    "CDRTARG" integer,
    "CIN" character varying(255),
    "CONT" character varying(255),
    "CONT_DATE" character varying(255),
    "CUST_CURR" character varying(255),
    "CUST_LIBL" character varying(255),
    "CUST_STTS" integer,
    "CUST_TYPE" character varying(255),
    "CU_ACTV" character varying(255),
    "CU_ANNE_CA" character varying(255),
    "CU_BLCK_LIST" character varying(255),
    "CU_CAPC_JUR" character varying(255),
    "CU_CAPT_SOCL" character varying(255),
    "CU_CHFF_AFFR" real,
    "CU_CODE_BCT" character varying(255),
    "CU_CODE_SIT_JUR" integer,
    "CU_DATE_SIT_JUR" integer,
    "CU_DT_INTR_CHE" character varying(255),
    "CU_DT_TRAN_CNTX" integer,
    "CU_FORM_JUR" integer,
    "CU_GROP_AFFR" character varying(255),
    "CU_INTR_CART" character varying(255),
    "CU_INTR_CHQ" character varying(255),
    "CU_NB_EMPL" character varying(255),
    "CU_POLE_GEST" character varying(255),
    "CU_PRFS" character varying(255),
    "CU_PRSP_TRE" character varying(255),
    "CU_QULT" character varying(255),
    "CU_TYPE_ADRS" character varying(255),
    "DATCHG" integer,
    "DATE_AUT_BCT" integer,
    "DATE_EXPR_PASS" character varying(255),
    "DATE_OF_BIRTH" character varying(255),
    "DATFINVLD" integer,
    "DERSIT" integer,
    "EMAL_1" character varying(255),
    "EMPL_STTS" character varying(255),
    "EXNR_TVA" character varying(255),
    "FAMILY_NAME" character varying(255),
    "GEND" character varying(255),
    "GIVEN_NAMES" character varying(255),
    "ID" character varying(255),
    "IDNT_FISC" character varying(255),
    "IDNT_UNQ" character varying(255),
    "ID_BCT" character varying(255),
    "INDS" integer,
    "ISSU_CHQU" character varying(255),
    "JOB_TITL" character varying(255),
    "LANG" integer,
    "LEGL_EXP_DATE" integer,
    "MANL_RISK_CLSS" character varying(255),
    "MART_STTS" character varying(255),
    "MATR_FISC" character varying(255),
    "MNMN" character varying(255),
    "NAME_1" character varying(255),
    "NATN" character varying(255),
    "NET_MONT_IN" character varying(255),
    "NET_MONT_OUT" character varying(255),
    "NUMR_ANLT_CODE_PTT_GRFF" character varying(255),
    "NUM_BCT" character varying(255),
    "OTHR_NATN" character varying(255),
    "OTHR_OFFC" character varying(255),
    "OVRR_RESN" character varying(255),
    "PASS" character varying(255),
    "PATN" character varying(255),
    "PHNE_1" character varying(255),
    "POST_CODE" character varying(255),
    "POST_REST" integer,
    "RESD" character varying(255),
    "SALR" character varying(255),
    "SECT" character varying(255),
    "SHORT_NAME" character varying(255),
    "SMS_1" character varying(255),
    "SRC" character varying(255),
    "STRT" character varying(255),
    "TARG" integer,
    "TITL" character varying(255),
    "TOWN_CONT" character varying(255),
    "TYPE_ID_BCT" character varying(255),
    "VISA" character varying(255)
);


ALTER TABLE public."E_CUSTOMER" OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 58221)
-- Name: E_CUSTOMER_RELATION; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_CUSTOMER_RELATION" (
    "CDRCUST" integer NOT NULL,
    "CDRRELTCUST" integer NOT NULL,
    "ID" character varying(10) NOT NULL,
    "RELT_CUST" character varying(10) NOT NULL,
    "RELT_CODE" integer NOT NULL,
    "REVR_REL_CODE" character varying(3),
    "CDRRELT" integer,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_CUSTOMER_RELATION" OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 58226)
-- Name: E_DRAWINGS; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_DRAWINGS" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying(200) NOT NULL,
    "DRWN_TYPE" character varying(200),
    "DRW_CURR" character varying(200),
    "DOCM_AMNT" double precision,
    "VALU_DATE" integer,
    "DRWD_ACCNT" character varying(200),
    "PAMN_METH" character varying(200),
    "PAMN_ACCNT" character varying(200),
    "PAMN_AMNT" double precision,
    "REMB_AMNT" double precision,
    "LIMT_REFR" character varying(200),
    "DOC_AMT_LOCL" double precision,
    "DOC_AMT_LC_CCY" double precision,
    "FULL_UTLS" character varying(200),
    "LC_CRDT_TYPE" character varying(200),
    "CUST_LINK" character varying(200),
    "PROV_AMT_REL" character varying(19),
    "LC_LIAB_RELS" double precision,
    "LC_LIAB_REL_LCY" double precision,
    "REMB_AMT_LCCY" double precision,
    "PAY_AMT_LCCY" double precision,
    "PROV_REL_LC_CCY" double precision,
    "PROV_REL_DOC_CCY" double precision,
    "MATR_REVW" integer,
    "CHRG_CODE" character varying(200),
    "CHRG_CURR" character varying(200),
    "CHRG_AMNT" character varying(200),
    "RELTED_DRWN" character varying(200),
    "CHRG_LCCY_AMT" character varying(200),
    "TYP_ENG" character varying(200),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer,
    "DERSIT" integer,
    "DATCHG" integer
);


ALTER TABLE public."E_DRAWINGS" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 58233)
-- Name: E_ENCOURS; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_ENCOURS" (
    "CDRCONTMUTL" integer NOT NULL,
    "REF_CONT" character varying(15) NOT NULL,
    "MONT_ENCR_INTL_TND" numeric(15,3),
    "MONT_ENCR_REDR_TND" numeric(15,3),
    "MONT_ENCR_INTL_DEV" numeric(15,3),
    "MONT_ENCR_REDR_DEV" numeric(15,3),
    "CODE_TYP_ENCR" integer NOT NULL,
    "STATUT" character(1) NOT NULL,
    "CDR_TYP_ENCR" integer,
    "DAT_SIT" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" character varying(20) NOT NULL
);


ALTER TABLE public."E_ENCOURS" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 58238)
-- Name: E_ENCOURS_PERSO_BIAT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_ENCOURS_PERSO_BIAT" (
    "CDRCONTRH" integer NOT NULL,
    "REF_CONT" character varying(15) NOT NULL,
    "MONT_ENCR_INTL" numeric(15,3),
    "MONT_ENCR" numeric(15,3),
    "MONT_ENCR_TND" numeric(15,3),
    "CODE_TYP_ENCR" integer NOT NULL,
    "STATUT" character varying(1) NOT NULL,
    "DAT_SIT" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" character varying(20) NOT NULL,
    cdrcontmutl integer
);


ALTER TABLE public."E_ENCOURS_PERSO_BIAT" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 58243)
-- Name: E_LC; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_LC" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying NOT NULL,
    "CUST" character varying,
    "CURR" character varying,
    "ACCN" character varying,
    "TYPE_ENG" character varying,
    "ISSU_DATE" integer,
    "EXPR_DATE" integer,
    "OPRT" character varying,
    "LC_TYPE" character varying,
    "EXTR_REFR" character varying,
    "CHRG_ACCN" character varying,
    "LC_AMNT" double precision,
    "DAY_BASS" character varying,
    "CURR_MARK" character varying,
    "POST_TYPE" character varying,
    "LIMT_REFR" character varying,
    "EXPR_PLAC" character varying,
    "CLSN_DATE" integer,
    "BENF_CUST" character varying,
    "CATG_CODE" character varying,
    "ACCN_OFFC" character varying,
    "LIBL_AMT" double precision,
    "LC_AMNT_LOCL" double precision,
    "DRWN" double precision,
    "NEXT_DRWN" character varying,
    "PAMN_AMT" double precision,
    "APPL_CUST" character varying,
    "APPL_ACC" character varying,
    "FULLY_UTLS" character varying,
    "PRVS_PERC" character varying,
    "PRVS_AMNT" double precision,
    "PRO_OUT_AMNT" double precision,
    "PRO_AWAT_REL" double precision,
    "PRVS_RATE" double precision,
    "BENF" character varying,
    "DRAW_TYPE" character varying,
    "LIAB_PORT_AMT" double precision,
    "LCY_PORT_AMT" double precision,
    "LR_EFF_AVAL" character varying,
    "LR_REF_AVAL" character varying,
    "NUMR_COMP" character varying,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_LC" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 58250)
-- Name: E_LD; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_LD" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying(200) NOT NULL,
    "CUST_ID" character varying(200),
    "CURR" character varying(200),
    "VALU_DATE" integer,
    "FIN_MAT_DATE" integer,
    "LIMT_REFR" character varying(200),
    "CATG" character varying(200),
    "DRWD_ACCN" character varying(200),
    "INT_RATE_TYPE" character varying(200),
    "INTR_BASI" character varying(200),
    "INT_PAMT_METH" character varying(200),
    "INTR_KEY" character varying(200),
    "INTR_SPRD" real,
    "ACCR_PARM" character varying(200),
    "LIQU_MODE" character varying(200),
    "OVRD_STTS" character varying(200),
    "GRAC_PERD" character varying(200),
    "GRAC_AMNT" character varying(200),
    "PRIN_LIQ_ACCT" character varying(200),
    "INT_LIQ_ACCT" character varying(200),
    "CHRG_LIQ_ACCT" character varying(200),
    "MIS_ACCT_OFFC" character varying(200),
    "AGRM_DATE" integer,
    "CONR_RISK" character varying(200),
    "CONT_EXPS" character varying(200),
    "STTS" character varying(200),
    "DRWD_ISSU_PRC" real,
    "DRWD_NET_AMT" real,
    "REMB_AMNT" real,
    "FEE_PAY_ACCNT" character varying(200),
    "AMNT_INCR" character varying(200),
    "NEW_SPRD" character varying(200),
    "SPRD_V_DATE" character varying(200),
    "DRWD_ENT_DATE" integer,
    "CO_CODE" character varying(200),
    "A_PRRG" character varying(35),
    "A_RENV" character varying(15),
    "BANQ_TIRE" character varying(10),
    "BILL_NUMB" character varying(12),
    "CHRG_AMNT" character varying(10),
    "CHRG_BOKD_ON" integer,
    "CHRG_CPTL" character varying(35),
    "CHRG_CLM_DATE" integer,
    "CHRG_CODE" character varying(3),
    "CLE_TAUX_BASE" integer,
    "CONT_MARC" character varying(18),
    "DURE_CRDT" real,
    "ENCR_INTL" real,
    "INTR_RATE" real,
    "LD_INTR_NET" real,
    "LD_MARG" real,
    "LD_MARG_INIT" real,
    "LD_NANT" character varying(35),
    "LIB_TYPE_ENG" character varying(100),
    "MARG" real,
    "NIV_DELG_MAX" character varying(35),
    "NOM_TIRE" character varying(100),
    "OUR_REMR" character varying(35),
    "REF_MARC" character varying(15),
    "REF_TITR_CRDT" character varying(35),
    "RIB_TIRE" character varying(35),
    "TAUX_BASE" real,
    "TAUX_GLBL" real,
    "TIEG" real,
    "TIEX" real,
    "TITR" character varying(35),
    "TYPE_CRDT" character varying(35),
    "TYPE_ENG" character varying(35),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_LD" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 58257)
-- Name: E_MD; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_MD" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying(17) NOT NULL,
    "CURR" character varying(3),
    "CUST" character varying(10),
    "TYP_ENG" character varying(35),
    "ACCN" character varying(35),
    "VALU_DATE" character varying(11),
    "MATR_DATE" character varying(11),
    "EPS_MONT_INI" character varying,
    "CCY_MARK" character varying,
    "PRNC_AMNT" character varying,
    "DEAL_DATE" character varying,
    "CONT_TYPE" character varying,
    "DEAL_SUB_TYPE" character varying,
    "CATG" character varying,
    "LIMT_UPD_REQD" character varying,
    "LIMT_REFR" character varying,
    "ACCN_OFFC" character varying,
    "CONT_RISK" character varying,
    "CONT_EXPS" character varying,
    "LIMT_AMNT" character varying,
    "STTS" character varying,
    "NET_PRIN_AMNT" character varying,
    "INCL_PRVS" character varying,
    "PRVS" character varying,
    "PROV_DR_ACCNT" character varying,
    "PROV_PERC" character varying,
    "PROV_AMNT" character varying,
    "PROV_REL_DATE" integer,
    "PROV_REL_ACCN" character varying,
    "AUTO_EXPR" character varying,
    "ALTR_ID" character varying,
    "LIQD_MODE" character varying,
    "CHRG_DATE" character varying,
    "CHRG_CURR" character varying,
    "CHRG_ACCN" character varying,
    "TAX_CODE" character varying,
    "BEN_ADDR" character varying,
    "EPS_REF_MARC" character varying,
    "EPS_MOTF_APUR" character varying,
    "EPS_MODF" character varying,
    "EPS_ECH_INTL" integer,
    "EPS_TYPE_DOC" character varying,
    "EPS_DELV" character varying,
    "EPS_AVIS_MJEU" character varying,
    "EPS_CAUT_MODL" character varying,
    "EPS_RECP" character varying,
    "EPS_DELV_REMP" character varying,
    "EPS_DT_RECP_MJ" integer,
    "EPS_PIST_CMC7" character varying,
    "EPS_MONTN_EFF" character varying,
    "EPS_ECH_EFFT" integer,
    "EPS_RIB_DEST" character varying,
    "EPS_PAMN_MJ" character varying,
    "EPS_DEST" character varying,
    "EPS_DT_REMS_C" integer,
    "EPS_NBJR_VALI" integer,
    "EPS_PORC_CD" integer,
    "EPS_MOTF_ANNL" character varying,
    "EPS_CONT_MAR" character varying,
    "EPS_ACCN" character varying,
    "MIGR" character varying,
    "NIV_DELG_MAX" character varying,
    "EPS_VALD" character varying,
    "EPS_MODL" character varying,
    "EPS_APR_PART" character varying,
    "EPS_APR_ECH_AUT" character varying,
    "EPS_MOIS_INDV" character varying,
    "LIB_TYPE_ENG" character varying,
    "EPS_TEMP_INV" double precision,
    "EPS_TEMP_PROV" double precision,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_MD" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 58264)
-- Name: E_MG; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_MG" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying NOT NULL,
    "CUST" character varying,
    "CONT_TYP" character varying,
    "CONT_STTS" character varying,
    "CURR" character varying,
    "PRNC_AMNT" double precision,
    "CATG" character varying,
    "CONT_DATE" integer,
    "VAL_DATE" integer,
    "TERM" real,
    "ORGN_MAT_DATE" integer,
    "MATR_DATE" integer,
    "INTR_BASS" character varying,
    "EFFC_INT" character varying,
    "REPM_DATE" character varying(19),
    "REDM_DATE" character varying,
    "REDM_STRT_DATE" integer,
    "REPM_AMNT" double precision,
    "THRT_AMNT" double precision,
    "LIQU_MODE" character varying,
    "OVRD_STTS" character varying,
    "LIMT_REF" character varying,
    "MORT_ACCN" character varying,
    "DRWD_ACCN" character varying,
    "TOTL_CHRG" double precision,
    "TOTL_CHG_TAX" double precision,
    "MIS_ACCT_OFFC" character varying,
    "INTL_RATE" double precision,
    "INT_LIQ_ACCT" character varying,
    "CO_CODE" character varying,
    "MG_TIEX" double precision,
    "INTR_KEY" character varying,
    "MG_REF_CONV" character varying,
    "PAMN_TYPE" character varying,
    "FIXD_VAR_IND" character varying,
    "MG_TIEG" double precision,
    "MG_REF_VERS" character varying,
    "DETL_BESN" character varying,
    "NIV_DELG_MAX" character varying,
    "MG_REF_DEMN" character varying,
    "MG_REF_BESN" character varying,
    "OUR_REMR" character varying,
    "TYPE_CREDT" character varying,
    "INTR_SPRD" double precision,
    "MG_TAUX_BASE" double precision,
    "MG_MARG" real,
    "CHRG_TAX_LCY" character varying,
    "CHRG_CODE" character varying,
    "CHRG_DATE" character varying,
    "INTR_RATE" double precision,
    "CHRG_CCY" character varying,
    "CHRG_AMNT" character varying,
    "CHRG_ACCN" character varying,
    "TYPE_ENG" character varying,
    "MG_REF_TITR_CR" character varying,
    "CHRG_AMT_LCY" character varying,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_MG" OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 58271)
-- Name: E_PD; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_PD" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying NOT NULL,
    "CUSTOMER" character varying,
    "CURRENCY" character varying,
    "CURRENCY_MARKET" character varying,
    "POSITION_TYPE" character varying,
    "ACCOUNT_OFFICER" character varying,
    "CATEGORY" character varying,
    "INTEREST_BASIS" character varying,
    "PENALTY_RATE" character varying,
    "PENALTY_KEY" character varying,
    "PENALTY_SPREAD" character varying,
    "PARAMETER_RECORD" character varying,
    "ORIG_LIMIT_REF" character varying,
    "LIMIT_REFERENCE" character varying,
    "FINAL_DUE_DATE" character varying,
    "REPAYMENT_ACCT" character varying,
    "START_DATE" character varying,
    "CO_CODE" character varying,
    "ACCRUAL_PARAM" character varying,
    "ROUNDING_RULE" character varying,
    "WAIVE_GRA_PE" character varying,
    "WAIVE_GRA_PS" character varying,
    "ORIG_STLMNT_ACT" character varying,
    "REPAID_STATUS" character varying,
    "TYPE_CREDIT" character varying,
    "TYPE_ENG" character varying,
    "LIB_TYPE_ENG" character varying,
    "PRIORITE_IMPAYE" character varying,
    "INTERVALLE_IMP" character varying,
    "ENV_RECOUV_EXT" character varying,
    "TYPE_RECOUV_EXT" character varying,
    "RS_RECOUV_EXT" character varying,
    "DOC_RECOUV_EXT" character varying,
    "NAT_DOC_RECOUV" character varying,
    "REFERENCE" character varying,
    "COMPTE" character varying,
    "COURS_CHANGE" character varying,
    "LC_NUMBER_12" character varying,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_PD" OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 58278)
-- Name: E_PD_DETAIL; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_PD_DETAIL" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying(35) NOT NULL,
    "DAT_ECHN" character varying(8),
    "REF_CONT" character varying(14),
    "ANCN" character varying(8),
    "MONT_PRNC_INTL" character varying(30),
    "MONT_PRNC_INTL_RED" character varying(30),
    "MONT_PRNC_INTL_TND" character varying(30),
    "MONT_PRNC_ACTL" character varying(30),
    "MONT_PRNC_ACTL_RED" character varying(30),
    "MONT_PRNC_ACTL_TND" character varying(30),
    "MONT_INTR_INTL" character varying(30),
    "MONT_INTR_INTL_RED" character varying(30),
    "MONT_INTR_INTL_TND" character varying(30),
    "MONT_INTR_ACTL" character varying(30),
    "MONT_INTR_ACTL_RED" character varying(30),
    "MONT_INTR_ACTL_TND" character varying(30),
    "MONT_INTR_RETR_1_INTL" character varying(30),
    "MONT_INTR_RETR_1_INTL_RED" character varying(30),
    "MONT_INTR_RETR_1_INTL_TND" character varying(30),
    "MONT_INTR_RETR_1_ACTL" character varying(30),
    "MONT_INTR_RETR_1_ACTL_RED" character varying(30),
    "MONT_INTR_RETR_1_ACTL_TND" character varying(30),
    "MONT_INTR_RETR_2_INTL" character varying(30),
    "MONT_INTR_RETR_2_INTL_RED" character varying(30),
    "MONT_INTR_RETR_2_INTL_TND" character varying(30),
    "MONT_INTR_RETR_2_ACTL" character varying(30),
    "MONT_INTR_RETR_2_ACTL_RED" character varying(30),
    "MONT_INTR_RETR_2_ACTL_TND" character varying(30),
    "MONT_WS_INTL" character varying(30),
    "MONT_WS_INTL_RED" character varying(30),
    "MONT_WS_INTL_TND" character varying(30),
    "MONT_WS_ACTL" character varying(30),
    "MONT_WS_ACTL_RED" character varying(30),
    "MONT_WS_ACTL_TND" character varying(30),
    "MONT_WE_INTL" character varying(30),
    "MONT_WE_INTL_RED" character varying(30),
    "MONT_WE_INTL_TND" character varying(30),
    "MONT_WE_ACTL" character varying(30),
    "MONT_WE_ACTL_RED" character varying(30),
    "MONT_WE_ACTL_TND" character varying(30),
    "DAT_SIT" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" character varying(20) NOT NULL
);


ALTER TABLE public."E_PD_DETAIL" OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 58285)
-- Name: E_PD_MONTANT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_PD_MONTANT" (
    "CDRCONTMUTL" integer NOT NULL,
    "ID" character varying NOT NULL,
    "TOTAL_AMT_TO_REPAY" character varying,
    "ANCIENNETE_IMP" character varying,
    "INTERET" character varying,
    "PRINCIPAL" character varying,
    "PENALITE_RETARD_PS" character varying,
    "PENALITE_RETARD_WE" character varying,
    "PENALITE_RETARD_WS" character varying,
    "PENALITE_RETARD_PE" character varying,
    "MONTANT" character varying,
    "DAT_SIT" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."E_PD_MONTANT" OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 58292)
-- Name: E_TITRE_CREDIT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_TITRE_CREDIT" (
    "CDR_TITR" integer NOT NULL,
    "REF_TITRE" character varying(200) NOT NULL,
    "REF_CREDIT" character varying(200),
    "DATE_GENR" character varying(200),
    "ORDRE_TRNC" character varying(200),
    "CODE_CLNT" character varying(200),
    "COM_CLNT" character varying(200),
    "ADRS_CLNT" character varying(200),
    "DOMC_BANC" character varying(200),
    "COMP_CLNT" character varying(200),
    "CPTE_CLT_CTOS" character varying(200),
    "RIB_CLNT" character varying(200),
    "CATG" character varying(200),
    "TYP_CRDT" character varying(200),
    "TYP_INTR" character varying(200),
    "DUREE" character varying(200),
    "DAT_SOSC" character varying(200),
    "LIEU_SOSC" character varying(200),
    "TAUX_CMP" character varying(200),
    "MONT_CMP" character varying(200),
    "TAUX_CETD" character varying(200),
    "MONT_CETD" character varying(200),
    "TAUX_COM_ENG" character varying(200),
    "TAUX_CONT_FNG" character varying(200),
    "TAUX_SOTUGAR" character varying(200),
    "MONT_DEBL" character varying(200),
    "TAUX_BASE" character varying(200),
    "MARG" character varying(200),
    "TAUX_APPL" character varying(200),
    "TIEG" character varying(200),
    "TAUX_CPG" character varying(200),
    "TAUX_CG" character varying(200),
    "MNT_TOT_INT" character varying(200),
    "TYPE_REMB" character varying(200),
    "DAT_DEBLC_THQ" character varying(200),
    "DAT_DEBLC_EFF" character varying(200),
    "DAT_SIGN_CNTR" character varying(200),
    "DAT_P_ECH_INT" character varying(200),
    "DAT_P_ECH_PPL" character varying(200),
    "PERDCT_PPL" character varying(200),
    "PERDCT_INT" character varying(200),
    "ANNTE" character varying(200),
    "NB_ECHN" character varying(200),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer,
    "DERSIT" integer,
    "DATCHG" integer
);


ALTER TABLE public."E_TITRE_CREDIT" OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 58299)
-- Name: E_TITRE_CREDIT_ECHEANCIER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_TITRE_CREDIT_ECHEANCIER" (
    "CDR_TITR" integer,
    "REF_TITR" character varying(20) NOT NULL,
    "NUM_ECHN" integer NOT NULL,
    "DATE_ECH" integer,
    "NB_JOURS_ECH" integer,
    "ENCR_ECH" numeric(15,3),
    "REF_CTOS_PPL" character varying(15),
    "MNT_PPL_ECH" numeric(15,3),
    "REF_CTOS_INT" character varying(15),
    "MNT_INT_ECH" numeric(15,3),
    "MNT_INT_COM_ECH" numeric(15,3),
    "MNT_TOT_ECH" numeric(15,3),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer,
    "DERSIT" integer,
    "DATCHG" integer
);


ALTER TABLE public."E_TITRE_CREDIT_ECHEANCIER" OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 58304)
-- Name: E_TITRE_CREDIT_ECHEANCIER_temp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."E_TITRE_CREDIT_ECHEANCIER_temp" (
    "ID" character varying,
    "BLOC" character varying,
    "CHAMP" character varying,
    "VALEUR" character varying,
    "DAT_SIT" integer,
    "DAT_CHG" integer,
    "DAT_CSO" integer
);


ALTER TABLE public."E_TITRE_CREDIT_ECHEANCIER_temp" OWNER TO postgres;

--
-- TOC entry 285 (class 1259 OID 59017)
-- Name: Functions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Functions" (
    id bigint NOT NULL,
    name character varying(255),
    query character varying(255),
    queryexcel character varying(255),
    status integer
);


ALTER TABLE public."Functions" OWNER TO postgres;

--
-- TOC entry 284 (class 1259 OID 59016)
-- Name: Functions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Functions_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Functions_id_seq" OWNER TO postgres;

--
-- TOC entry 3879 (class 0 OID 0)
-- Dependencies: 284
-- Name: Functions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Functions_id_seq" OWNED BY public."Functions".id;


--
-- TOC entry 304 (class 1259 OID 133216)
-- Name: History; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."History" (
    id bigint NOT NULL,
    actiontext character varying(255),
    actiontime timestamp without time zone,
    actiontype character varying(255)
);


ALTER TABLE public."History" OWNER TO postgres;

--
-- TOC entry 303 (class 1259 OID 133215)
-- Name: History_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."History_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."History_id_seq" OWNER TO postgres;

--
-- TOC entry 3880 (class 0 OID 0)
-- Dependencies: 303
-- Name: History_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."History_id_seq" OWNED BY public."History".id;


--
-- TOC entry 289 (class 1259 OID 100067)
-- Name: Menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Menu" (
    id bigint NOT NULL,
    active boolean NOT NULL,
    checked boolean NOT NULL,
    iconcomponent character varying(255),
    idparent bigint,
    level integer NOT NULL,
    name character varying(255),
    url character varying(255)
);


ALTER TABLE public."Menu" OWNER TO postgres;

--
-- TOC entry 302 (class 1259 OID 125103)
-- Name: Menu_composants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Menu_composants" (
    "Menu_id" bigint NOT NULL,
    composants_id bigint NOT NULL
);


ALTER TABLE public."Menu_composants" OWNER TO postgres;

--
-- TOC entry 288 (class 1259 OID 100066)
-- Name: Menu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Menu_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Menu_id_seq" OWNER TO postgres;

--
-- TOC entry 3881 (class 0 OID 0)
-- Dependencies: 288
-- Name: Menu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Menu_id_seq" OWNED BY public."Menu".id;


--
-- TOC entry 313 (class 1259 OID 174277)
-- Name: Message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Message" (
    id bigint NOT NULL,
    codeclient character varying(255),
    compteclient character varying(255),
    idresponsemessage bigint,
    object character varying(255),
    processstatus character varying(255),
    receiver character varying(255),
    sender character varying(255),
    status character varying(255),
    text character varying(255),
    "timestamp" timestamp without time zone,
    type character varying(255),
    classe integer,
    motif character varying(255)
);


ALTER TABLE public."Message" OWNER TO postgres;

--
-- TOC entry 314 (class 1259 OID 174285)
-- Name: Message_attachements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Message_attachements" (
    "Message_id" bigint NOT NULL,
    attachements_id bigint NOT NULL
);


ALTER TABLE public."Message_attachements" OWNER TO postgres;

--
-- TOC entry 312 (class 1259 OID 174276)
-- Name: Message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Message_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Message_id_seq" OWNER TO postgres;

--
-- TOC entry 3882 (class 0 OID 0)
-- Dependencies: 312
-- Name: Message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Message_id_seq" OWNED BY public."Message".id;


--
-- TOC entry 230 (class 1259 OID 58309)
-- Name: P_TYP_ENG_BCT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."P_TYP_ENG_BCT" (
    "TYPE_ENCR" character varying(50) NOT NULL,
    "TYPE_ENG" character varying(50) NOT NULL,
    "CODE_BCT" character varying(50) NOT NULL,
    "USG" character varying(50),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."P_TYP_ENG_BCT" OWNER TO postgres;

--
-- TOC entry 294 (class 1259 OID 108553)
-- Name: Permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Permissions" (
    id bigint NOT NULL,
    menu_id bigint
);


ALTER TABLE public."Permissions" OWNER TO postgres;

--
-- TOC entry 293 (class 1259 OID 108552)
-- Name: Permissions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Permissions_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Permissions_id_seq" OWNER TO postgres;

--
-- TOC entry 3883 (class 0 OID 0)
-- Dependencies: 293
-- Name: Permissions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Permissions_id_seq" OWNED BY public."Permissions".id;


--
-- TOC entry 292 (class 1259 OID 108447)
-- Name: Profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Profile" (
    id bigint NOT NULL,
    profiletype character varying(255)
);


ALTER TABLE public."Profile" OWNER TO postgres;

--
-- TOC entry 291 (class 1259 OID 108446)
-- Name: Profile_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Profile_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Profile_id_seq" OWNER TO postgres;

--
-- TOC entry 3884 (class 0 OID 0)
-- Dependencies: 291
-- Name: Profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Profile_id_seq" OWNED BY public."Profile".id;


--
-- TOC entry 295 (class 1259 OID 108618)
-- Name: Profile_permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Profile_permissions" (
    "Profile_id" bigint NOT NULL,
    permissions_id bigint NOT NULL
);


ALTER TABLE public."Profile_permissions" OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 58314)
-- Name: R_ACTIVITE; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_ACTIVITE" (
    "CDRACTV" integer NOT NULL,
    "CDRCONTMUTL" integer,
    "ID" character varying(5) NOT NULL,
    "LIBL" character varying(200),
    "CORR_BCT" character varying(7),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_ACTIVITE" OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 58319)
-- Name: R_BIAT_PROFESSION; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_BIAT_PROFESSION" (
    "CDRBIATPRFS" integer NOT NULL,
    "ID" character varying(4) NOT NULL,
    "LIBL" character varying(75),
    "CORR_BCT" character varying(4),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" integer NOT NULL
);


ALTER TABLE public."R_BIAT_PROFESSION" OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 58324)
-- Name: R_CATEGORY; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_CATEGORY" (
    "CDRCATG" integer NOT NULL,
    "ID" character varying(6) NOT NULL,
    "SYST_IND" character varying(3),
    "MNMN" character varying(10),
    "AC_CONT" character varying(35),
    "DESC" character varying(35),
    "SHRT_NAM" character varying(15),
    "LIGN_PRD" character varying(35),
    "TAXB" character varying(35),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_CATEGORY" OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 58329)
-- Name: R_CODE_ENG; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_CODE_ENG" (
    "CDRCODENG" integer NOT NULL,
    "ID" character varying(10) NOT NULL,
    "DESC" character varying(200),
    "CATG" character varying(35),
    "LIGN_PRDT" character varying(35),
    "PRIO_IMP" character varying(35),
    "DATE_DEBT" character varying(35),
    "DATE_FIN" character varying(35),
    "LIMT_REF" integer,
    "TYPE_LIMT" character varying(35),
    "DEVS" character varying(100000),
    "CATG_COMP" character varying(100000),
    "RECC_BIAT" character varying(15),
    "COD_ENG_BCT" character varying(4),
    "CDRCODENGBCT" integer,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_CODE_ENG" OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 58336)
-- Name: R_CODE_ENG_BCT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_CODE_ENG_BCT" (
    "CDRCODENGBCT" integer NOT NULL,
    "CODE_BCT" character varying(4) NOT NULL,
    "TYPE_CODE_BCT" integer NOT NULL,
    "LIBELLE_LONG_CODE_BCT" character varying(200),
    "LIBELLE_COURT_CODE_BCT" character varying(100),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" integer NOT NULL
);


ALTER TABLE public."R_CODE_ENG_BCT" OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 58341)
-- Name: R_CODE_ENG_PERSO_BIAT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_CODE_ENG_PERSO_BIAT" (
    "CDRCODENGRH" integer NOT NULL,
    "CODE_ENGG" character varying(3) NOT NULL,
    "CODE_CRDT" character varying(3),
    "LIBL" character varying(100),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_CODE_ENG_PERSO_BIAT" OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 58346)
-- Name: R_INDUSTRY; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_INDUSTRY" (
    "CDRINDS" integer NOT NULL,
    "ID" integer NOT NULL,
    "DESC" character varying(100),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_INDUSTRY" OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 58351)
-- Name: R_LIMITES; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_LIMITES" (
    "CDRLIMT" integer NOT NULL,
    "ID" integer NOT NULL,
    "DESC" character varying(35),
    "SHRT_NAM" character varying(15),
    "FX_OR_TIME_BAND" character varying(2),
    "REDC_LIMT" character varying(1),
    "LIMT_MNMN" character varying(4),
    "LIMT_KEY_TYP" character varying(7),
    "LIMT_PERC" character varying(3),
    "DEFL_CHCK" character varying(2),
    "PARN_REFR" character varying(7),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVAL" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" integer NOT NULL,
    datfinvld integer
);


ALTER TABLE public."R_LIMITES" OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 58356)
-- Name: R_RELATION; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_RELATION" (
    "CDRRELT" integer NOT NULL,
    "ID" integer NOT NULL,
    "DESC" character varying,
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_RELATION" OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 58363)
-- Name: R_TARGET; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_TARGET" (
    "CDRTARG" integer NOT NULL,
    "ID" integer NOT NULL,
    "DESC" character varying(35),
    "SHRT_NAM" character varying(100),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DAT_CHG" integer NOT NULL
);


ALTER TABLE public."R_TARGET" OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 58368)
-- Name: R_TYPE_CREDIT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_TYPE_CREDIT" (
    "CDRCODENG" integer NOT NULL,
    "ID" character varying(7) NOT NULL,
    "LIBL" character varying(200),
    "CATG" integer,
    "LIGN_PRDT" integer,
    "APPL" character varying(2),
    "LIMT_REF" integer,
    "PRIO_IMP" integer,
    "DATE_DEBT" integer,
    "DATE_FIN" integer,
    "TYPE_LIMT" character varying(3),
    "GEST_VERS" integer,
    "IND_STND" character varying(3),
    "ELEG_REFN" integer,
    "ELEG_TITR" integer,
    "ELEG_SOTGR" integer,
    "ELEG_FNG" integer,
    "ELEG_COF" integer,
    "RENV_PRRG" character varying(35),
    "CAT_TIEX" character varying(3),
    "CODE_KFCR" integer,
    "LIEN_EPRG" integer,
    "MONT_MIN" double precision,
    "MONTT_MAX" double precision,
    "MNT_NET_GLB_MAX" double precision,
    "MNT_NET_MAX_TRX" double precision,
    "TX_ENDT_MAX" double precision,
    "REF_MARC" character varying(3),
    "REF_EXPR" character varying(3),
    "CLE_TX_BASE" character varying(4),
    "TYPE_DECM" character varying(4),
    "TYPE_INTR" character varying(8),
    "BASE_INTR" character varying(4),
    "MARG_STD" real,
    "MARG_MIN" real,
    "MARG_MAX" real,
    "TAUX_MIN" real,
    "TAUX_MAX" real,
    "MARG_PENL" real,
    "CHRG_CMP" character varying(35),
    "CHRG_ETD_ACR" character varying(35),
    "CHRG_ETD_REJ" character varying(35),
    "CHRG_RB_ANTC" character varying(35),
    "CHRG_REMB_ECH" character varying(35),
    "CHRG_COM_ENG" character varying(35),
    "COMM_PC" integer,
    "COMM_G" integer,
    "DURE_MIN" character varying(3),
    "DURE_MAX" character varying(4),
    "ECH_MAX" integer,
    "DURE_MAX_GB" character varying(5),
    "DEBL_TRNC" integer,
    "SUPP_MOB" character varying(35),
    "VALD_OFFR" character varying(3),
    "FRCH_MIN_THQ" character varying(3),
    "FRCH_MAX_THQ" character varying(3),
    "ANTC_DEBL_MAX" character varying(3),
    "VALD_TC" character varying(3),
    "FRCH_MIN_EFF" character varying(3),
    "LIEU_CONS_VM" character varying(20),
    "RECC_IMP_BIAT" character varying(6),
    "TYPE_DEBL" character varying(6),
    "COMM_MISE_IMP" character varying(15),
    "RECR_STTS" character varying,
    "CO_CODE" character varying,
    "DEPT_CODE" character varying,
    "DEVS" character varying(100000),
    "CATG_COMP" character varying(100000),
    "TYPE_REMB" character varying(9),
    "DATE_TIME" double precision,
    "PER_REMB_PPL" character varying(500),
    "PER_REMB_INT" character varying(500),
    "OPTN_COMP" character varying(500),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_TYPE_CREDIT" OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 58375)
-- Name: R_TYPE_ENCOUR; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_TYPE_ENCOUR" (
    "CDR_TYP_ENCR" integer,
    "ID" integer NOT NULL,
    "LIB_LONG" character varying(45),
    "LIB_CORT" character varying(15),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer,
    "DERSIT" integer,
    "DATCHG" integer
);


ALTER TABLE public."R_TYPE_ENCOUR" OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 58380)
-- Name: R_TYPE_ENG; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_TYPE_ENG" (
    "CDRCODENG" integer NOT NULL,
    "ID" character varying(10) NOT NULL,
    "LIBL" character varying(60),
    "FAML_PRCS" character varying(60),
    "LIGN_PRDT" character varying(60),
    "CATG" character varying(60),
    "LIMT_REF" integer,
    "TYPE_LIMT" character varying(60),
    "MODL_STD_MEP" character varying(60),
    "AUTR_DEVS" character varying(60),
    "DATE_DEBT" character varying(60),
    "DATE_FIN" character varying(60),
    "IND_STND" character varying(60),
    "LIEN_EPRG" character varying(60),
    "RECC_BIAT" integer,
    "ELEG_COF" character varying(60),
    "TABL_REFR" character varying(60),
    "TYPE_NOTF" character varying(60),
    "ETAP_NOTF" character varying(60),
    "DELS_NOTF" character varying(60),
    "RECR_STTS" character varying(4),
    "CURR_NO" integer,
    "DEPT_CODE" character varying(4),
    "DEVS" character varying(3),
    "DATE_TIME" double precision,
    "DEVS_ENG" character varying(3),
    "TX_ENDT_MAX" character varying(60),
    "DEVS_TX" character varying(3),
    "REVN_MIN" character varying(60),
    "REVN_MAX" character varying(60),
    "CODE_KFCR" character varying(60),
    "SUPP_MOB" character varying(60),
    "LIEU_CONS_VM" character varying(60),
    "QUTT_FIN" character varying(60),
    "ELGB_TRE" character varying(60),
    "QUTT_FIN_TRE" character varying(60),
    "FRCH_THQ_INT" character varying(60),
    "MONT" character varying(60),
    "MNT_NET_GLB" character varying(60),
    "MNT_NET_TRX" character varying(60),
    "CAT_TIEX" character varying(60),
    "CLE_TX_BASE" character varying(60),
    "TYPE_DECM" character varying(60),
    "TYPE_INTR" character varying(60),
    "BASE_INTR" character varying(60),
    "MARG_STD" character varying(60),
    "MARG" character varying(60),
    "CHRG_CMP" character varying(60),
    "CHRG_ETD_ACR" character varying(60),
    "CHRG_ETD_REJ" character varying(60),
    "CHRG_RB_ANTC" character varying(60),
    "CHRG_REMB_ECH" character varying(60),
    "CHRG_COM_ENG" character varying(60),
    "COMM_PCG" character varying(60),
    "COMM_MISE_IMP" character varying(60),
    "TYPE_REMB" character varying(60),
    "DEBL_TRNC" character varying(60),
    "NBR_TRC" character varying(60),
    "PER_REMB_PPL" character varying(60),
    "PER_REMB_INT" character varying(60),
    "DURE" character varying(60),
    "VALD_OFFR" character varying(60),
    "PERD_LATN" character varying(60),
    "FRCH_THQ_PPL" character varying(60),
    "ANTC_DEBL" character varying(60),
    "VALD_TC" character varying(60),
    "ELEG_REFN" character varying(60),
    "ELEG_TITR" character varying(60),
    "ELEG_SOTG" character varying(60),
    "ELEG_FNG" character varying(60),
    "LIEN_PROM_IMMO" character varying(60),
    "CATG_COMP" character varying(60),
    "PRIO_IMP" character varying(60),
    "ELEG_DHMN" character varying(60),
    "CRD_AUTR_TYPE_TAUX" character varying(60),
    "TYPS_ENG_LIES" character varying(60),
    "MRG_B_FONDS" character varying(60),
    "ELEG_TUNS" character varying(60),
    "CALC_TUNS_CH" character varying(60),
    "METH_MEP" character varying(60),
    "EXEC_VIR_DEBL" character varying(60),
    "CPT_INTR_DEBL" character varying(60),
    "TAUX_EQUV" character varying(60),
    "CPT_INT_TRES_A_RECV" character varying(60),
    "CPT_PL_TRES_A_RECV" character varying(60),
    "CPT_INT_TRES_RECV" character varying(60),
    "CPT_INT_TRES_IMP" character varying(60),
    "CPT_PPL_IMP" character varying(60),
    "CPT_PPL_RECV" character varying(60),
    "INDIC_FOND_ETAT" character varying(60),
    "RAPP_GAR_CRD" character varying(60),
    "MNT_INV_MAX" character varying(60),
    "OPTN_COMP" character varying(60),
    "CPT_INT_RETR_TRES_A_RECV" character varying(60),
    "CPT_PL_INT_RETAR_TRES" character varying(60),
    "CPT_INT_RETR_RECV" character varying(60),
    "COMP_FOND" character varying(60),
    "ELIG_FGIC" character varying(60),
    "ELEG_SARE" character varying(60),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_TYPE_ENG" OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 58387)
-- Name: R_TYPE_ENG_MD; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_TYPE_ENG_MD" (
    "CDRCODENG" integer NOT NULL,
    "ID" character varying(7) NOT NULL,
    "DESC" character varying(60),
    "CATG" integer,
    "LIGN_PRDT" character varying(3),
    "PRIO_IMP" integer,
    "CODE_KFCR" character varying(4),
    "DATE_DEBUT" integer,
    "DATE_FIN" integer,
    "TYPE_LIMT" character varying(3),
    "TYPE_PRDT" character varying(10),
    "MODL" character varying(3),
    "APR_PART" character varying(3),
    "APR_ECH_AUT" character varying(3),
    "LIMIT_REF" integer,
    "MOIS_INDV" character varying(3),
    "REF_MARC" character varying(3),
    "REF_CNTR_MARC" character varying(3),
    "TX_FINN" character varying(6),
    "COMM_RISQ" character varying(15),
    "PERD_COM_RISQ" character varying(15),
    "COMM_MEP_EPS" character varying(15),
    "COM_MODF_CLNT" character varying(15),
    "COMM_M_JEU" character varying(15),
    "RECC_BIAT" character varying(15),
    "RECR_STTS" character varying(4),
    "CO_CODE" character varying(40),
    "DEPT_CODE" character varying(10),
    "DEVS" character varying(1000),
    "CATG_COMP" character varying(1000),
    "COM_APRM" character varying(35),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_TYPE_ENG_MD" OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 58394)
-- Name: R_UNITGEST; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."R_UNITGEST" (
    "CDR_UNIT_GEST" integer NOT NULL,
    "ID" character varying(20) NOT NULL,
    "AREA" character varying(20),
    "NAME" character varying(50),
    "TELEPHONE_NO" character varying(16),
    "RECORD_STATUS" character varying(3),
    "CO_CODE" character varying(35),
    "DEPT_LEVEL" character varying(15),
    "DEPT_PARENT" integer,
    "CODE_AGENCE" character varying(11),
    "CODE_AGENCE_BCT" character varying(20),
    "CODE_AGENCE_RIB" character varying(100),
    "CODE_COMPANY" character varying(100),
    "ATQ_WU" character varying(11),
    "LR_LONGITUDE" character varying(20),
    "LR_LATITUDE" character varying(20),
    "LR_GOUVERNERAT" character varying(35),
    "TYPE_AGENCE" character varying(50),
    "CLSS" character varying(50),
    "DATE_OUVT" character varying(16),
    "DATDEBVLD" integer NOT NULL,
    "DATFINVLD" integer NOT NULL,
    "DERSIT" integer NOT NULL,
    "DATCHG" integer NOT NULL
);


ALTER TABLE public."R_UNITGEST" OWNER TO postgres;

--
-- TOC entry 297 (class 1259 OID 116832)
-- Name: Tree; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Tree" (
    id bigint NOT NULL,
    agence character varying(255),
    pole character varying(255),
    region character varying(255),
    zone character varying(255)
);


ALTER TABLE public."Tree" OWNER TO postgres;

--
-- TOC entry 296 (class 1259 OID 116831)
-- Name: Tree_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Tree_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Tree_id_seq" OWNER TO postgres;

--
-- TOC entry 3885 (class 0 OID 0)
-- Dependencies: 296
-- Name: Tree_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Tree_id_seq" OWNED BY public."Tree".id;


--
-- TOC entry 287 (class 1259 OID 75504)
-- Name: Url; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Url" (
    id bigint NOT NULL,
    component character varying(255),
    url character varying(255)
);


ALTER TABLE public."Url" OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 75503)
-- Name: Url_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Url_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Url_id_seq" OWNER TO postgres;

--
-- TOC entry 3886 (class 0 OID 0)
-- Dependencies: 286
-- Name: Url_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Url_id_seq" OWNED BY public."Url".id;


--
-- TOC entry 299 (class 1259 OID 116853)
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Users" (
    id bigint NOT NULL,
    libelle character varying(255),
    email character varying(255),
    lastlogout timestamp without time zone,
    registerdate timestamp without time zone,
    status character varying(255),
    userfirstname character varying(255),
    userlastname character varying(255),
    username character varying(255),
    userpassword character varying(255),
    profile character varying(255),
    initials character varying(255)
);


ALTER TABLE public."Users" OWNER TO postgres;

--
-- TOC entry 305 (class 1259 OID 133224)
-- Name: Users_histories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Users_histories" (
    "User_id" bigint NOT NULL,
    histories_id bigint NOT NULL
);


ALTER TABLE public."Users_histories" OWNER TO postgres;

--
-- TOC entry 298 (class 1259 OID 116852)
-- Name: Users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Users_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Users_id_seq" OWNER TO postgres;

--
-- TOC entry 3887 (class 0 OID 0)
-- Dependencies: 298
-- Name: Users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Users_id_seq" OWNED BY public."Users".id;


--
-- TOC entry 246 (class 1259 OID 58655)
-- Name: account_perso_biat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_perso_biat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_perso_biat_seq OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 58656)
-- Name: account_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_seq OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 58657)
-- Name: contrat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contrat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contrat_seq OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 58658)
-- Name: customer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_seq OWNER TO postgres;

--
-- TOC entry 250 (class 1259 OID 58659)
-- Name: e_account_solde_perso_biat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_account_solde_perso_biat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_account_solde_perso_biat_seq OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 58660)
-- Name: e_account_solde_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_account_solde_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_account_solde_seq OWNER TO postgres;

--
-- TOC entry 252 (class 1259 OID 58661)
-- Name: e_contrat_perso_biat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_contrat_perso_biat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_contrat_perso_biat_seq OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 58662)
-- Name: e_currency_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_currency_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_currency_seq OWNER TO postgres;

--
-- TOC entry 254 (class 1259 OID 58663)
-- Name: e_customer_relation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_customer_relation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_customer_relation_seq OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 58664)
-- Name: e_drawings_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_drawings_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_drawings_seq OWNER TO postgres;

--
-- TOC entry 256 (class 1259 OID 58665)
-- Name: e_encours_perso_biat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_encours_perso_biat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_encours_perso_biat_seq OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 58666)
-- Name: e_lc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_lc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_lc_seq OWNER TO postgres;

--
-- TOC entry 258 (class 1259 OID 58667)
-- Name: e_ld_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_ld_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_ld_seq OWNER TO postgres;

--
-- TOC entry 259 (class 1259 OID 58668)
-- Name: e_md_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_md_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_md_seq OWNER TO postgres;

--
-- TOC entry 260 (class 1259 OID 58669)
-- Name: e_mg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_mg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_mg_seq OWNER TO postgres;

--
-- TOC entry 261 (class 1259 OID 58670)
-- Name: e_pd_detail_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_pd_detail_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_pd_detail_seq OWNER TO postgres;

--
-- TOC entry 262 (class 1259 OID 58671)
-- Name: e_pd_montant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_pd_montant_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_pd_montant_seq OWNER TO postgres;

--
-- TOC entry 263 (class 1259 OID 58672)
-- Name: e_pd_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_pd_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_pd_seq OWNER TO postgres;

--
-- TOC entry 264 (class 1259 OID 58673)
-- Name: e_titre_credit_echeancier_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_titre_credit_echeancier_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_titre_credit_echeancier_seq OWNER TO postgres;

--
-- TOC entry 265 (class 1259 OID 58674)
-- Name: e_titre_credit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.e_titre_credit_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.e_titre_credit_seq OWNER TO postgres;

--
-- TOC entry 266 (class 1259 OID 58675)
-- Name: encours_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encours_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encours_seq OWNER TO postgres;

--
-- TOC entry 290 (class 1259 OID 108416)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 267 (class 1259 OID 58676)
-- Name: p_typ_eng_bct_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.p_typ_eng_bct_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.p_typ_eng_bct_seq OWNER TO postgres;

--
-- TOC entry 268 (class 1259 OID 58677)
-- Name: r_activite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_activite_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_activite_seq OWNER TO postgres;

--
-- TOC entry 269 (class 1259 OID 58678)
-- Name: r_biat_profession_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_biat_profession_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_biat_profession_seq OWNER TO postgres;

--
-- TOC entry 270 (class 1259 OID 58679)
-- Name: r_category_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_category_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_category_seq OWNER TO postgres;

--
-- TOC entry 271 (class 1259 OID 58680)
-- Name: r_code_eng_bct_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_code_eng_bct_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_code_eng_bct_seq OWNER TO postgres;

--
-- TOC entry 272 (class 1259 OID 58681)
-- Name: r_code_eng_perso_biat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_code_eng_perso_biat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_code_eng_perso_biat_seq OWNER TO postgres;

--
-- TOC entry 273 (class 1259 OID 58682)
-- Name: r_code_eng_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_code_eng_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_code_eng_seq OWNER TO postgres;

--
-- TOC entry 274 (class 1259 OID 58683)
-- Name: r_industry_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_industry_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_industry_seq OWNER TO postgres;

--
-- TOC entry 275 (class 1259 OID 58684)
-- Name: r_limites_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_limites_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_limites_seq OWNER TO postgres;

--
-- TOC entry 276 (class 1259 OID 58685)
-- Name: r_relation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_relation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_relation_seq OWNER TO postgres;

--
-- TOC entry 277 (class 1259 OID 58686)
-- Name: r_target_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_target_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_target_seq OWNER TO postgres;

--
-- TOC entry 278 (class 1259 OID 58687)
-- Name: r_type_credit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_type_credit_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_type_credit_seq OWNER TO postgres;

--
-- TOC entry 279 (class 1259 OID 58688)
-- Name: r_type_encour_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_type_encour_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_type_encour_seq OWNER TO postgres;

--
-- TOC entry 280 (class 1259 OID 58689)
-- Name: r_type_eng_md_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_type_eng_md_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_type_eng_md_seq OWNER TO postgres;

--
-- TOC entry 281 (class 1259 OID 58690)
-- Name: r_type_eng_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_type_eng_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_type_eng_seq OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 58691)
-- Name: r_unitgest_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.r_unitgest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.r_unitgest_seq OWNER TO postgres;

--
-- TOC entry 315 (class 1259 OID 174540)
-- Name: tab1; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tab1 (
    cpte character varying(255) NOT NULL,
    actfin bigint,
    act_biat bigint,
    agios_ech_int bigint,
    agios_eff_imp bigint,
    agios_eff_imp_deb bigint,
    agios_res bigint,
    agios_x bigint,
    assur bigint,
    avalbq bigint,
    classe character varying(255),
    codrisk character varying(255),
    cotunace bigint,
    depots bigint,
    dont_cesur bigint,
    ecart_prov bigint,
    engsiga bigint,
    engsigb bigint,
    fng bigint,
    garbq bigint,
    garded bigint,
    garetat bigint,
    gar_even bigint,
    hypo bigint,
    idbct character varying(255),
    identif character varying(255),
    motif character varying(255),
    nom character varying(255),
    periode timestamp without time zone,
    pod bigint,
    prov_adit bigint,
    prov_req bigint,
    pro_cons bigint,
    risk_brut bigint,
    risk_net bigint,
    solde_agios_deb_tri bigint,
    typeidbct character varying(255)
);


ALTER TABLE public.tab1 OWNER TO postgres;

--
-- TOC entry 316 (class 1259 OID 174547)
-- Name: tab2; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tab2 (
    cpte character varying(255) NOT NULL,
    agios bigint,
    clascon character varying(255),
    clasgel character varying(255),
    clasimp character varying(255),
    clasmaxident character varying(255),
    classub character varying(255),
    cloture character varying(255),
    datcloture character varying(255),
    ech_anc character varying(255),
    identif character varying(255),
    impinter bigint,
    impprinc bigint,
    mtf_con character varying(255),
    mtf_sub character varying(255),
    mvt bigint,
    periode timestamp without time zone,
    soldcpte bigint
);


ALTER TABLE public.tab2 OWNER TO postgres;

--
-- TOC entry 3468 (class 2604 OID 149642)
-- Name: Attachement id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Attachement" ALTER COLUMN id SET DEFAULT nextval('public."Attachement_id_seq"'::regclass);


--
-- TOC entry 3469 (class 2604 OID 157819)
-- Name: Chat chat_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat" ALTER COLUMN chat_id SET DEFAULT nextval('public."Chat_chat_id_seq"'::regclass);


--
-- TOC entry 3471 (class 2604 OID 174691)
-- Name: Classification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Classification" ALTER COLUMN id SET DEFAULT nextval('public."Classification_id_seq"'::regclass);


--
-- TOC entry 3466 (class 2604 OID 125098)
-- Name: Composant id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Composant" ALTER COLUMN id SET DEFAULT nextval('public."Composant_id_seq"'::regclass);


--
-- TOC entry 3472 (class 2604 OID 184129)
-- Name: DownloadPin id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."DownloadPin" ALTER COLUMN id SET DEFAULT nextval('public."DownloadPin_id_seq"'::regclass);


--
-- TOC entry 3459 (class 2604 OID 59020)
-- Name: Functions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Functions" ALTER COLUMN id SET DEFAULT nextval('public."Functions_id_seq"'::regclass);


--
-- TOC entry 3467 (class 2604 OID 133219)
-- Name: History id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."History" ALTER COLUMN id SET DEFAULT nextval('public."History_id_seq"'::regclass);


--
-- TOC entry 3461 (class 2604 OID 100070)
-- Name: Menu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu" ALTER COLUMN id SET DEFAULT nextval('public."Menu_id_seq"'::regclass);


--
-- TOC entry 3470 (class 2604 OID 174280)
-- Name: Message id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Message" ALTER COLUMN id SET DEFAULT nextval('public."Message_id_seq"'::regclass);


--
-- TOC entry 3463 (class 2604 OID 108556)
-- Name: Permissions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Permissions" ALTER COLUMN id SET DEFAULT nextval('public."Permissions_id_seq"'::regclass);


--
-- TOC entry 3462 (class 2604 OID 108450)
-- Name: Profile id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profile" ALTER COLUMN id SET DEFAULT nextval('public."Profile_id_seq"'::regclass);


--
-- TOC entry 3464 (class 2604 OID 116835)
-- Name: Tree id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tree" ALTER COLUMN id SET DEFAULT nextval('public."Tree_id_seq"'::regclass);


--
-- TOC entry 3460 (class 2604 OID 75507)
-- Name: Url id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Url" ALTER COLUMN id SET DEFAULT nextval('public."Url_id_seq"'::regclass);


--
-- TOC entry 3465 (class 2604 OID 116856)
-- Name: Users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users" ALTER COLUMN id SET DEFAULT nextval('public."Users_id_seq"'::regclass);


--
-- TOC entry 3852 (class 0 OID 149639)
-- Dependencies: 307
-- Data for Name: Attachement; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Attachement" VALUES (339, 'TB_PROD_Listedesclients2', '3b8c8486-1406-4541-b9b0-03bc984c33c9', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (340, 'TB_PROD_Listedesclients8', '0d356e5d-43b8-4ef5-8555-459dbf7766d7', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (341, 'TB_PROD_Listedesclients2', 'f287d4e0-17ee-4851-8c67-5cf129e13a68', '16739', 'vnd.openxmlformats-officedocument.spreadsheetml.sheet');
INSERT INTO public."Attachement" VALUES (342, 'TB_PROD_Listedesclients-12', '37573196-1696-4325-b189-891276db920d', '3372', 'vnd.openxmlformats-officedocument.spreadsheetml.sheet');
INSERT INTO public."Attachement" VALUES (343, 'TB_PROD_Listedesclients', '9c98e691-bd62-43a2-a773-1292d5e91e0b', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (344, 'TB_CdR_Liste des clients3', 'bff9cbc6-e045-4515-b4fe-1ea348544012', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (345, 'TB_CdR_Liste des clients3', '4dc3fbc1-1f8f-43dd-9f66-79004cd1b4cf', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (346, 'TB_CdR_Listedesclients7', '0d9cd4bd-bd7a-416f-8745-5ddc0df1f74b', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (347, 'TB_PROD_Listedesclients', '66f0c62b-312f-4f9a-a0db-94610aa62898', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (348, 'TB_PROD_Listedesclients1', 'fc61a4b1-efb4-4e07-af1c-1a9abdaeb6b1', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (349, 'TB_PROD_Listedesclients-RR', '430e29a7-1868-4665-8eb0-693104a0b428', '3544', 'xlsx');
INSERT INTO public."Attachement" VALUES (350, 'TB_PROD_Listedesclients-RR-13', 'e2fb0035-776a-4ee3-99c3-d1c98a2e2f33', '3402', 'xlsx');
INSERT INTO public."Attachement" VALUES (351, 'TB_PROD_Listedesclients-13', 'bb27f088-eb56-405f-bc79-a78ec0b0624d', '3403', 'xlsx');
INSERT INTO public."Attachement" VALUES (352, 'TB_PROD_Listedesclients', '37afb79c-7d82-4ade-9903-5db7de81dcaa', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (353, 'TB_PROD_Listedesclients8', '2e69c303-9b1c-4179-958b-5bebf6919878', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (354, 'TB_AGC_Listedesclients6', 'a408d873-0b34-467e-870b-dbe14d6c378d', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (355, 'TB_AGC_Listedesclients6', 'b5bb5c5c-a9ae-4f7e-a606-642eab0cf383', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (356, 'TB_PROD_Listedesclients', '05f9b5bc-e25b-4b12-bb14-9b0b5fa0f4ae', '16739', 'xlsx');
INSERT INTO public."Attachement" VALUES (357, 'TB_PROD_Listedesclients1', '9edd8968-bc9d-4f61-b7d9-bb13fe47d2e2', '16739', 'xlsx');


--
-- TOC entry 3854 (class 0 OID 157816)
-- Dependencies: 309
-- Data for Name: Chat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Chat" VALUES (1, 'chat1');
INSERT INTO public."Chat" VALUES (2, 'chat2');
INSERT INTO public."Chat" VALUES (3, 'chat3');


--
-- TOC entry 3855 (class 0 OID 157834)
-- Dependencies: 310
-- Data for Name: Chat_messages; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3856 (class 0 OID 157837)
-- Dependencies: 311
-- Data for Name: Chat_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Chat_users" VALUES (1, 1);
INSERT INTO public."Chat_users" VALUES (1, 3);


--
-- TOC entry 3863 (class 0 OID 174688)
-- Dependencies: 318
-- Data for Name: Classification; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Classification" VALUES (7, 2, 'ppppp', 'Acceptation', 'M', 'ccc');
INSERT INTO public."Classification" VALUES (12, NULL, 'texte ddd', NULL, NULL, 'ddd');
INSERT INTO public."Classification" VALUES (13, NULL, 'texte', NULL, NULL, 'eee');
INSERT INTO public."Classification" VALUES (8, NULL, 'mmm', 'Refus', NULL, 'fff');


--
-- TOC entry 3864 (class 0 OID 174696)
-- Dependencies: 319
-- Data for Name: Classification_attachements; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3865 (class 0 OID 174741)
-- Dependencies: 320
-- Data for Name: Client; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Client" VALUES ('ddd', '13', 'agence', 'ons');
INSERT INTO public."Client" VALUES ('eee', '13', 'agence', 'ons');
INSERT INTO public."Client" VALUES ('ccc', '13', 'agence', 'ons1');
INSERT INTO public."Client" VALUES ('aaa', '13', 'agence', 'ons');
INSERT INTO public."Client" VALUES ('fff', '11', 'agence', 'ons');
INSERT INTO public."Client" VALUES ('bbb', '12', 'agence', 'noussa');
INSERT INTO public."Client" VALUES ('ggg', '13', 'agence', 'noussa');
INSERT INTO public."Client" VALUES ('hhh', '11', 'AGENCE', 'noussa');


--
-- TOC entry 3846 (class 0 OID 125095)
-- Dependencies: 301
-- Data for Name: Composant; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Composant" VALUES (14, 'liste des clients', 'select account, profile,code from "Client"', 'Composant 2');
INSERT INTO public."Composant" VALUES (15, 'liste des clients', 'select * from "Client"', 'Composant 3');
INSERT INTO public."Composant" VALUES (18, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'select code from "Client"', 'Composant 225');
INSERT INTO public."Composant" VALUES (19, 'kkkk', 'select * from "Client"', 'Composant menu n');


--
-- TOC entry 3867 (class 0 OID 184126)
-- Dependencies: 322
-- Data for Name: DownloadPin; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."DownloadPin" VALUES (1, '2023-05-01 21:25:13.185452', true, '866093', 3);
INSERT INTO public."DownloadPin" VALUES (2, '2023-05-01 21:28:58.818867', true, '676624', 13);


--
-- TOC entry 3754 (class 0 OID 58178)
-- Dependencies: 209
-- Data for Name: E_ACCOUNT; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."E_ACCOUNT" VALUES (60, 'd', 'd', 'd', 'd', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 60, 'q', 50, 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 50, 50, 50, 50, 5650);


--
-- TOC entry 3755 (class 0 OID 58185)
-- Dependencies: 210
-- Data for Name: E_ACCOUNT_PERSO_BIAT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3756 (class 0 OID 58192)
-- Dependencies: 211
-- Data for Name: E_ACCOUNT_SOLDE; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3757 (class 0 OID 58197)
-- Dependencies: 212
-- Data for Name: E_ACCOUNT_SOLDE_PERSO_BIAT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3758 (class 0 OID 58202)
-- Dependencies: 213
-- Data for Name: E_CONTRAT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3759 (class 0 OID 58209)
-- Dependencies: 214
-- Data for Name: E_CONTRAT_PERSO_BIAT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3760 (class 0 OID 58216)
-- Dependencies: 215
-- Data for Name: E_CURRENCY; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3828 (class 0 OID 58981)
-- Dependencies: 283
-- Data for Name: E_CUSTOMER; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."E_CUSTOMER" VALUES (0, 0, 'a', 'a', 'a', 'a', 'a', 0, 0, 0, 0, 'a', 'a', 'a', 'a', 'a', 0, 'a', 'a', 'a', 'a', 'a', 'a', 0, 'a', 0, 0, 'a', 0, 0, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 0, 0, 'a', 'a', 0, 0, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 0, 'a', 'a', 0, 0, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 0, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 0, 'a', 'a', 'a', 'a');


--
-- TOC entry 3761 (class 0 OID 58221)
-- Dependencies: 216
-- Data for Name: E_CUSTOMER_RELATION; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3762 (class 0 OID 58226)
-- Dependencies: 217
-- Data for Name: E_DRAWINGS; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3763 (class 0 OID 58233)
-- Dependencies: 218
-- Data for Name: E_ENCOURS; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."E_ENCOURS" VALUES (1, 'h', 1.000, 1.000, 0.000, 0.000, 0, 'r', 20223117, 0, 0, '');
INSERT INTO public."E_ENCOURS" VALUES (0, 'a', 0.000, 0.000, 0.000, 0.000, 0, 'z', 0, 20220513, 0, 'a');
INSERT INTO public."E_ENCOURS" VALUES (0, 'a', 0.000, 0.000, 0.000, 0.000, 0, 'z', 0, 20220515, 0, 'a');
INSERT INTO public."E_ENCOURS" VALUES (0, 'a', 0.000, 0.000, 0.000, 0.000, 0, 'z', 0, 20220517, 0, 'a');
INSERT INTO public."E_ENCOURS" VALUES (0, 'a', 0.000, 0.000, 0.000, 0.000, 0, 'z', 0, 20230517, 0, 'a');


--
-- TOC entry 3764 (class 0 OID 58238)
-- Dependencies: 219
-- Data for Name: E_ENCOURS_PERSO_BIAT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3765 (class 0 OID 58243)
-- Dependencies: 220
-- Data for Name: E_LC; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3766 (class 0 OID 58250)
-- Dependencies: 221
-- Data for Name: E_LD; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3767 (class 0 OID 58257)
-- Dependencies: 222
-- Data for Name: E_MD; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3768 (class 0 OID 58264)
-- Dependencies: 223
-- Data for Name: E_MG; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3769 (class 0 OID 58271)
-- Dependencies: 224
-- Data for Name: E_PD; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3770 (class 0 OID 58278)
-- Dependencies: 225
-- Data for Name: E_PD_DETAIL; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3771 (class 0 OID 58285)
-- Dependencies: 226
-- Data for Name: E_PD_MONTANT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3772 (class 0 OID 58292)
-- Dependencies: 227
-- Data for Name: E_TITRE_CREDIT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3773 (class 0 OID 58299)
-- Dependencies: 228
-- Data for Name: E_TITRE_CREDIT_ECHEANCIER; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3774 (class 0 OID 58304)
-- Dependencies: 229
-- Data for Name: E_TITRE_CREDIT_ECHEANCIER_temp; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3830 (class 0 OID 59017)
-- Dependencies: 285
-- Data for Name: Functions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Functions" VALUES (6, 'Nom de la fonction', 'select * from "E_ACCOUNT"', NULL, 1);
INSERT INTO public."Functions" VALUES (7, 'Nom de la fonction', 'select * from "E_ACCOUNT"', NULL, 1);
INSERT INTO public."Functions" VALUES (8, 'test function', 'select * from "E_ENCOURS"', NULL, 1);
INSERT INTO public."Functions" VALUES (9, 'testttttttttttttttt', 'select * from "E_ENCOURS"', 'select * from "E_ENCOURS"', 0);
INSERT INTO public."Functions" VALUES (3, 'f2', 'select * from "E_ENCOURS" where "DERSIT"=20221515 ;', 'select', 1);
INSERT INTO public."Functions" VALUES (4, 'f1', 'select * from "E_ENCOURS" where "DERSIT" = 1', 'select', 0);
INSERT INTO public."Functions" VALUES (2, 'fonc', 'select * from "E_ENCOURS"', '', 0);
INSERT INTO public."Functions" VALUES (10, 'Nom de la fonction', 'select * from public."client"', NULL, 1);


--
-- TOC entry 3849 (class 0 OID 133216)
-- Dependencies: 304
-- Data for Name: History; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."History" VALUES (1, 'Add new menu', '2023-02-28 10:16:36.464188', 'ADD');
INSERT INTO public."History" VALUES (2, 'Update menu url', '2023-02-28 10:16:46.029907', 'UPDATE');
INSERT INTO public."History" VALUES (3, 'Update menu name', '2023-02-28 10:17:31.63907', 'UPDATE');
INSERT INTO public."History" VALUES (4, 'Update menu name', '2023-02-28 10:17:31.834256', 'UPDATE');
INSERT INTO public."History" VALUES (5, 'Update menu name', '2023-02-28 10:17:31.909482', 'UPDATE');
INSERT INTO public."History" VALUES (6, 'Update menu name', '2023-02-28 10:17:32.02979', 'UPDATE');
INSERT INTO public."History" VALUES (7, 'Update menu name', '2023-02-28 10:17:32.271436', 'UPDATE');
INSERT INTO public."History" VALUES (8, 'Update menu name', '2023-02-28 10:17:32.365941', 'UPDATE');
INSERT INTO public."History" VALUES (9, 'Delete menu', '2023-02-28 10:18:49.542895', 'DELETE');
INSERT INTO public."History" VALUES (10, 'Delete permission', '2023-02-28 13:24:45.590476', 'DELETE');
INSERT INTO public."History" VALUES (11, 'Update profile permissions', '2023-02-28 13:30:15.023776', 'UPDATE');
INSERT INTO public."History" VALUES (12, 'Update profile permissions', '2023-02-28 13:30:20.441256', 'UPDATE');
INSERT INTO public."History" VALUES (13, 'Update profile permissions', '2023-02-28 13:30:20.700324', 'UPDATE');
INSERT INTO public."History" VALUES (14, 'Delete permission', '2023-02-28 13:31:54.431803', 'DELETE');
INSERT INTO public."History" VALUES (15, 'Delete permission', '2023-02-28 13:31:57.353612', 'DELETE');
INSERT INTO public."History" VALUES (16, 'Update profile permissions', '2023-02-28 13:32:06.502741', 'UPDATE');
INSERT INTO public."History" VALUES (17, 'Update profile permissions', '2023-02-28 13:32:11.265154', 'UPDATE');
INSERT INTO public."History" VALUES (18, 'Delete permission', '2023-02-28 13:32:23.218922', 'DELETE');
INSERT INTO public."History" VALUES (19, 'Delete permission', '2023-02-28 13:32:28.989489', 'DELETE');
INSERT INTO public."History" VALUES (20, 'Update profile permissions', '2023-02-28 13:54:31.362663', 'UPDATE');
INSERT INTO public."History" VALUES (21, 'Delete permission', '2023-02-28 13:57:25.262421', 'DELETE');
INSERT INTO public."History" VALUES (22, 'Update profile permissions', '2023-02-28 13:57:51.652939', 'UPDATE');
INSERT INTO public."History" VALUES (23, 'Update profile permissions', '2023-02-28 14:57:22.750507', 'UPDATE');
INSERT INTO public."History" VALUES (24, 'Update profile permissions', '2023-02-28 14:57:22.573942', 'UPDATE');
INSERT INTO public."History" VALUES (25, 'Update profile permissions', '2023-02-28 14:57:22.750507', 'UPDATE');
INSERT INTO public."History" VALUES (26, 'Delete permission', '2023-02-28 15:01:42.188377', 'DELETE');
INSERT INTO public."History" VALUES (27, 'Update profile permissions', '2023-02-28 15:01:48.440284', 'UPDATE');
INSERT INTO public."History" VALUES (28, 'Add new menu', '2023-02-28 15:08:43.901718', 'ADD');
INSERT INTO public."History" VALUES (29, 'Update menu url', '2023-02-28 15:08:46.461865', 'UPDATE');
INSERT INTO public."History" VALUES (30, 'Update profile permissions', '2023-02-28 15:12:23.646672', 'UPDATE');
INSERT INTO public."History" VALUES (31, 'Add new composant', '2023-02-28 15:15:31.279021', 'ADD');
INSERT INTO public."History" VALUES (32, 'Add new composant', '2023-02-28 15:21:00.439947', 'ADD');
INSERT INTO public."History" VALUES (33, 'Delete menu', '2023-02-28 15:25:22.955343', 'DELETE');
INSERT INTO public."History" VALUES (34, 'Delete permission', '2023-02-28 15:25:35.131395', 'DELETE');
INSERT INTO public."History" VALUES (35, 'Add new menu', '2023-02-28 15:26:32.086681', 'ADD');
INSERT INTO public."History" VALUES (36, 'Update menu url', '2023-02-28 15:26:32.719336', 'UPDATE');
INSERT INTO public."History" VALUES (37, 'Add new composant', '2023-02-28 15:27:34.053664', 'ADD');
INSERT INTO public."History" VALUES (38, 'Update profile permissions', '2023-02-28 15:33:33.146581', 'UPDATE');
INSERT INTO public."History" VALUES (39, 'Update profile permissions', '2023-02-28 15:33:33.291263', 'UPDATE');
INSERT INTO public."History" VALUES (40, 'Delete permission', '2023-02-28 15:34:13.59103', 'DELETE');
INSERT INTO public."History" VALUES (41, 'Update profile permissions', '2023-02-28 15:34:38.525867', 'UPDATE');
INSERT INTO public."History" VALUES (42, 'Add new composant', '2023-02-28 15:36:16.912277', 'ADD');
INSERT INTO public."History" VALUES (43, 'Update profile permissions', '2023-02-28 15:45:49.044211', 'UPDATE');
INSERT INTO public."History" VALUES (44, 'Update user profile', '2023-02-28 15:50:02.808296', 'UPDATE');
INSERT INTO public."History" VALUES (45, 'Update user libelle', '2023-02-28 15:50:05.314268', 'UPDATE');
INSERT INTO public."History" VALUES (46, 'Update user libelle', '2023-02-28 15:50:06.010568', 'UPDATE');
INSERT INTO public."History" VALUES (47, 'Update profile permissions', '2023-03-03 18:39:18.149849', 'UPDATE');
INSERT INTO public."History" VALUES (48, 'Add new menu', '2023-03-03 19:30:00.75341', 'ADD');
INSERT INTO public."History" VALUES (49, 'Add new menu', '2023-03-03 19:31:20.765027', 'ADD');
INSERT INTO public."History" VALUES (50, 'Update menu url', '2023-03-03 19:31:23.576877', 'UPDATE');
INSERT INTO public."History" VALUES (51, 'Add new menu', '2023-03-03 19:44:03.2894', 'ADD');
INSERT INTO public."History" VALUES (52, 'Update menu url', '2023-03-03 19:44:04.223339', 'UPDATE');
INSERT INTO public."History" VALUES (53, 'Add new menu', '2023-03-03 19:47:28.938531', 'ADD');
INSERT INTO public."History" VALUES (54, 'Update menu url', '2023-03-03 19:47:29.337572', 'UPDATE');
INSERT INTO public."History" VALUES (55, 'Update profile permissions', '2023-03-03 19:48:57.741202', 'UPDATE');
INSERT INTO public."History" VALUES (56, 'Update profile permissions', '2023-03-03 19:48:58.477975', 'UPDATE');
INSERT INTO public."History" VALUES (57, 'Delete menu', '2023-03-03 22:04:15.56875', 'DELETE');
INSERT INTO public."History" VALUES (58, 'Add new menu', '2023-03-03 22:09:49.006117', 'ADD');
INSERT INTO public."History" VALUES (59, 'Update menu url', '2023-03-03 22:09:50.03268', 'UPDATE');
INSERT INTO public."History" VALUES (60, 'Delete permission', '2023-03-03 22:13:19.307472', 'DELETE');
INSERT INTO public."History" VALUES (61, 'Delete permission', '2023-03-03 22:13:34.918255', 'DELETE');
INSERT INTO public."History" VALUES (62, 'Add new menu', '2023-03-03 23:47:57.521607', 'ADD');
INSERT INTO public."History" VALUES (63, 'Update menu url', '2023-03-03 23:47:59.800439', 'UPDATE');
INSERT INTO public."History" VALUES (64, 'Update profile permissions', '2023-03-03 23:48:36.468062', 'UPDATE');
INSERT INTO public."History" VALUES (65, 'L''utilisateur Risque Reporting a passé une réclamation de type ''1''', '2023-03-07 09:40:10.844966', 'ADD');
INSERT INTO public."History" VALUES (66, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 10:47:42.75777', 'ADD');
INSERT INTO public."History" VALUES (67, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 10:50:31.924911', 'ADD');
INSERT INTO public."History" VALUES (68, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 10:53:58.359718', 'ADD');
INSERT INTO public."History" VALUES (69, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:29:28.56201', 'ADD');
INSERT INTO public."History" VALUES (70, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:30:24.425657', 'ADD');
INSERT INTO public."History" VALUES (71, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:30:51.989159', 'ADD');
INSERT INTO public."History" VALUES (72, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:31:44.381388', 'ADD');
INSERT INTO public."History" VALUES (73, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:32:24.02021', 'ADD');
INSERT INTO public."History" VALUES (74, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-07 11:34:27.579517', 'ADD');
INSERT INTO public."History" VALUES (75, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-07 11:37:17.520462', 'ADD');
INSERT INTO public."History" VALUES (76, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:45:04.214426', 'ADD');
INSERT INTO public."History" VALUES (77, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-07 11:49:09.633462', 'ADD');
INSERT INTO public."History" VALUES (78, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 11:53:53.000042', 'ADD');
INSERT INTO public."History" VALUES (79, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 11:56:45.792849', 'ADD');
INSERT INTO public."History" VALUES (80, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 11:59:02.691873', 'ADD');
INSERT INTO public."History" VALUES (81, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 12:00:05.50035', 'ADD');
INSERT INTO public."History" VALUES (82, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-07 12:01:30.709317', 'ADD');
INSERT INTO public."History" VALUES (83, 'L''utilisateur Risque Reporting a passé une réclamation de type ''bla bla bla''', '2023-03-08 07:51:03.154232', 'ADD');
INSERT INTO public."History" VALUES (84, 'L''utilisateur Risque Reporting a passé une réclamation de type ''''', '2023-03-08 07:54:40.739688', 'ADD');
INSERT INTO public."History" VALUES (85, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 07:57:07.75298', 'ADD');
INSERT INTO public."History" VALUES (86, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 08:01:31.280704', 'ADD');
INSERT INTO public."History" VALUES (87, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 08:03:36.306777', 'ADD');
INSERT INTO public."History" VALUES (88, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 08:07:45.869197', 'ADD');
INSERT INTO public."History" VALUES (89, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 08:13:23.661491', 'ADD');
INSERT INTO public."History" VALUES (90, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 09:20:38.968371', 'ADD');
INSERT INTO public."History" VALUES (91, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 09:20:58.077131', 'ADD');
INSERT INTO public."History" VALUES (95, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 11:06:06.68653', 'ADD');
INSERT INTO public."History" VALUES (92, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 11:06:06.68653', 'ADD');
INSERT INTO public."History" VALUES (94, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 11:06:06.68653', 'ADD');
INSERT INTO public."History" VALUES (93, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-08 11:06:06.68653', 'ADD');
INSERT INTO public."History" VALUES (96, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:43:05.54308', 'ADD');
INSERT INTO public."History" VALUES (97, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:43:09.141443', 'ADD');
INSERT INTO public."History" VALUES (98, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:43:14.036125', 'ADD');
INSERT INTO public."History" VALUES (99, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:43:52.288842', 'ADD');
INSERT INTO public."History" VALUES (100, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:52:03.528857', 'ADD');
INSERT INTO public."History" VALUES (101, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:54:12.838815', 'ADD');
INSERT INTO public."History" VALUES (102, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 08:57:23.628879', 'ADD');
INSERT INTO public."History" VALUES (103, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 08:59:36.152335', 'ADD');
INSERT INTO public."History" VALUES (104, 'L''utilisateur Risque Reporting a envoyé un message à ''zoneA@gmail.com''', '2023-03-09 09:04:26.546263', 'ADD');
INSERT INTO public."History" VALUES (105, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:06:11.542973', 'ADD');
INSERT INTO public."History" VALUES (106, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:12:09.385579', 'ADD');
INSERT INTO public."History" VALUES (107, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:12:14.752714', 'ADD');
INSERT INTO public."History" VALUES (108, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:12:29.66178', 'ADD');
INSERT INTO public."History" VALUES (109, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:14:09.427363', 'ADD');
INSERT INTO public."History" VALUES (110, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:14:13.762169', 'ADD');
INSERT INTO public."History" VALUES (111, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:15:17.015962', 'ADD');
INSERT INTO public."History" VALUES (112, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:15:33.036353', 'ADD');
INSERT INTO public."History" VALUES (113, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:17:17.023366', 'ADD');
INSERT INTO public."History" VALUES (114, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:20:50.1627', 'ADD');
INSERT INTO public."History" VALUES (115, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:21:36.613947', 'ADD');
INSERT INTO public."History" VALUES (116, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:24:02.443827', 'ADD');
INSERT INTO public."History" VALUES (117, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:34:32.920425', 'ADD');
INSERT INTO public."History" VALUES (118, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-09 09:36:52.52284', 'ADD');
INSERT INTO public."History" VALUES (119, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-09 09:41:06.698854', 'ADD');
INSERT INTO public."History" VALUES (120, 'L''utilisateur Risque Reporting a envoyé un message à ''agence11@gmail.com''', '2023-03-09 09:41:28.118222', 'ADD');
INSERT INTO public."History" VALUES (121, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-09 12:10:44.994033', 'ADD');
INSERT INTO public."History" VALUES (122, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-09 13:26:27.585697', 'ADD');
INSERT INTO public."History" VALUES (123, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-09 15:34:33.57242', 'ADD');
INSERT INTO public."History" VALUES (124, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-09 15:37:53.352808', 'ADD');
INSERT INTO public."History" VALUES (125, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-10 08:56:35.644436', 'ADD');
INSERT INTO public."History" VALUES (126, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-10 10:09:54.861765', 'ADD');
INSERT INTO public."History" VALUES (127, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-10 12:07:10.077543', 'ADD');
INSERT INTO public."History" VALUES (128, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-10 13:57:54.373519', 'ADD');
INSERT INTO public."History" VALUES (129, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-10 13:59:54.382842', 'ADD');
INSERT INTO public."History" VALUES (130, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-10 14:21:59.898195', 'ADD');
INSERT INTO public."History" VALUES (131, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-10 14:23:11.414179', 'ADD');
INSERT INTO public."History" VALUES (132, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-10 14:26:21.516965', 'ADD');
INSERT INTO public."History" VALUES (133, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-11 19:34:41.509364', 'ADD');
INSERT INTO public."History" VALUES (134, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-11 20:07:41.761247', 'ADD');
INSERT INTO public."History" VALUES (135, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-11 20:08:05.135278', 'ADD');
INSERT INTO public."History" VALUES (136, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-11 20:08:25.242894', 'ADD');
INSERT INTO public."History" VALUES (137, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-11 22:21:49.863925', 'ADD');
INSERT INTO public."History" VALUES (138, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-11 22:22:18.866976', 'ADD');
INSERT INTO public."History" VALUES (139, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-11 22:54:01.285985', 'ADD');
INSERT INTO public."History" VALUES (140, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-11 22:54:36.451076', 'UPDATE');
INSERT INTO public."History" VALUES (141, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-11 22:54:36.681718', 'UPDATE');
INSERT INTO public."History" VALUES (142, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-11 23:12:04.848775', 'ADD');
INSERT INTO public."History" VALUES (143, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-11 23:40:06.276939', 'ADD');
INSERT INTO public."History" VALUES (144, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-11 23:40:06.81968', 'UPDATE');
INSERT INTO public."History" VALUES (145, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-11 23:40:07.036696', 'UPDATE');
INSERT INTO public."History" VALUES (146, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-11 23:40:07.061629', 'UPDATE');
INSERT INTO public."History" VALUES (147, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-11 23:41:55.75447', 'UPDATE');
INSERT INTO public."History" VALUES (148, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-11 23:41:56.178598', 'UPDATE');
INSERT INTO public."History" VALUES (149, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-11 23:43:03.853405', 'UPDATE');
INSERT INTO public."History" VALUES (150, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-11 23:43:04.139734', 'UPDATE');
INSERT INTO public."History" VALUES (151, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-12 16:44:14.722523', 'ADD');
INSERT INTO public."History" VALUES (152, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-12 16:44:15.590884', 'UPDATE');
INSERT INTO public."History" VALUES (153, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-12 16:44:15.593877', 'UPDATE');
INSERT INTO public."History" VALUES (154, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-12 16:44:15.595873', 'UPDATE');
INSERT INTO public."History" VALUES (155, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-12 16:48:52.010296', 'UPDATE');
INSERT INTO public."History" VALUES (156, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 12:22:24.910038', 'UPDATE');
INSERT INTO public."History" VALUES (157, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 12:29:18.188162', 'ADD');
INSERT INTO public."History" VALUES (158, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 12:29:18.583216', 'UPDATE');
INSERT INTO public."History" VALUES (159, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 12:29:57.12105', 'UPDATE');
INSERT INTO public."History" VALUES (160, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 12:30:23.437147', 'UPDATE');
INSERT INTO public."History" VALUES (161, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 12:40:16.189086', 'UPDATE');
INSERT INTO public."History" VALUES (162, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 12:53:34.173244', 'UPDATE');
INSERT INTO public."History" VALUES (163, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-13 13:13:23.245401', 'ADD');
INSERT INTO public."History" VALUES (164, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:13:23.807666', 'UPDATE');
INSERT INTO public."History" VALUES (165, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:13:54.281088', 'UPDATE');
INSERT INTO public."History" VALUES (166, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 13:31:12.191235', 'ADD');
INSERT INTO public."History" VALUES (167, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:31:12.777238', 'UPDATE');
INSERT INTO public."History" VALUES (168, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:31:41.879782', 'UPDATE');
INSERT INTO public."History" VALUES (169, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 13:33:54.277866', 'ADD');
INSERT INTO public."History" VALUES (170, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:33:54.880379', 'UPDATE');
INSERT INTO public."History" VALUES (171, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:34:26.518499', 'UPDATE');
INSERT INTO public."History" VALUES (172, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-13 13:44:50.781739', 'ADD');
INSERT INTO public."History" VALUES (173, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:44:51.533775', 'UPDATE');
INSERT INTO public."History" VALUES (174, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:45:27.069436', 'UPDATE');
INSERT INTO public."History" VALUES (175, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 13:52:49.615415', 'ADD');
INSERT INTO public."History" VALUES (176, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:52:50.135298', 'UPDATE');
INSERT INTO public."History" VALUES (177, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:53:17.668102', 'UPDATE');
INSERT INTO public."History" VALUES (178, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:53:42.060214', 'UPDATE');
INSERT INTO public."History" VALUES (179, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 13:55:48.473102', 'ADD');
INSERT INTO public."History" VALUES (180, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:55:49.032945', 'UPDATE');
INSERT INTO public."History" VALUES (181, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 13:56:29.978159', 'UPDATE');
INSERT INTO public."History" VALUES (182, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 13:59:37.966177', 'ADD');
INSERT INTO public."History" VALUES (183, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 13:59:39.626481', 'UPDATE');
INSERT INTO public."History" VALUES (184, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:00:22.077519', 'UPDATE');
INSERT INTO public."History" VALUES (185, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:02:47.960469', 'UPDATE');
INSERT INTO public."History" VALUES (186, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-13 14:06:21.89839', 'ADD');
INSERT INTO public."History" VALUES (187, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:06:22.615258', 'UPDATE');
INSERT INTO public."History" VALUES (188, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:06:59.574916', 'UPDATE');
INSERT INTO public."History" VALUES (189, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:08:45.222166', 'UPDATE');
INSERT INTO public."History" VALUES (190, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 14:14:50.925158', 'ADD');
INSERT INTO public."History" VALUES (191, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:14:51.783266', 'UPDATE');
INSERT INTO public."History" VALUES (192, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:15:22.44353', 'UPDATE');
INSERT INTO public."History" VALUES (193, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-13 14:29:14.481154', 'ADD');
INSERT INTO public."History" VALUES (194, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:29:15.02071', 'UPDATE');
INSERT INTO public."History" VALUES (195, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:29:56.432114', 'UPDATE');
INSERT INTO public."History" VALUES (196, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:30:37.448165', 'UPDATE');
INSERT INTO public."History" VALUES (197, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:39:02.652703', 'UPDATE');
INSERT INTO public."History" VALUES (198, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-13 14:44:22.840929', 'ADD');
INSERT INTO public."History" VALUES (199, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:44:23.474393', 'UPDATE');
INSERT INTO public."History" VALUES (200, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:44:57.174086', 'UPDATE');
INSERT INTO public."History" VALUES (201, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:46:00.377346', 'UPDATE');
INSERT INTO public."History" VALUES (202, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-13 14:49:57.591571', 'ADD');
INSERT INTO public."History" VALUES (203, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:49:58.196484', 'UPDATE');
INSERT INTO public."History" VALUES (204, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:50:29.743079', 'UPDATE');
INSERT INTO public."History" VALUES (205, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:51:29.92925', 'UPDATE');
INSERT INTO public."History" VALUES (206, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-13 14:52:48.937514', 'ADD');
INSERT INTO public."History" VALUES (207, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:52:49.544648', 'UPDATE');
INSERT INTO public."History" VALUES (208, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-13 14:53:05.812349', 'ADD');
INSERT INTO public."History" VALUES (209, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-13 14:53:06.347047', 'UPDATE');
INSERT INTO public."History" VALUES (210, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:53:49.725025', 'UPDATE');
INSERT INTO public."History" VALUES (211, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:54:15.382795', 'UPDATE');
INSERT INTO public."History" VALUES (212, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:55:29.753527', 'UPDATE');
INSERT INTO public."History" VALUES (213, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:55:48.236753', 'UPDATE');
INSERT INTO public."History" VALUES (214, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-13 14:56:09.939664', 'UPDATE');
INSERT INTO public."History" VALUES (215, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 09:44:28.397454', 'ADD');
INSERT INTO public."History" VALUES (216, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 09:44:29.068251', 'UPDATE');
INSERT INTO public."History" VALUES (217, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-14 09:45:40.141105', 'UPDATE');
INSERT INTO public."History" VALUES (218, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 10:03:08.195783', 'ADD');
INSERT INTO public."History" VALUES (219, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 10:03:08.499356', 'UPDATE');
INSERT INTO public."History" VALUES (220, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 10:03:08.504343', 'UPDATE');
INSERT INTO public."History" VALUES (221, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 10:03:08.577148', 'UPDATE');
INSERT INTO public."History" VALUES (222, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 10:11:00.680345', 'ADD');
INSERT INTO public."History" VALUES (223, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 10:11:00.993566', 'UPDATE');
INSERT INTO public."History" VALUES (224, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-14 10:12:33.336414', 'UPDATE');
INSERT INTO public."History" VALUES (225, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-14 10:23:57.824644', 'UPDATE');
INSERT INTO public."History" VALUES (226, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-14 10:23:57.83761', 'UPDATE');
INSERT INTO public."History" VALUES (227, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 10:32:52.772603', 'ADD');
INSERT INTO public."History" VALUES (228, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 10:32:53.251188', 'UPDATE');
INSERT INTO public."History" VALUES (229, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 11:13:16.977388', 'ADD');
INSERT INTO public."History" VALUES (230, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 11:13:17.680507', 'UPDATE');
INSERT INTO public."History" VALUES (231, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 11:13:17.791212', 'UPDATE');
INSERT INTO public."History" VALUES (232, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 11:13:17.882966', 'UPDATE');
INSERT INTO public."History" VALUES (233, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-03-14 11:27:24.158253', 'ADD');
INSERT INTO public."History" VALUES (234, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 11:27:59.075255', 'ADD');
INSERT INTO public."History" VALUES (235, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 11:34:17.743115', 'ADD');
INSERT INTO public."History" VALUES (236, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 11:35:39.172453', 'ADD');
INSERT INTO public."History" VALUES (237, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:01:37.312631', 'ADD');
INSERT INTO public."History" VALUES (238, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:03:19.231235', 'ADD');
INSERT INTO public."History" VALUES (239, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:04:25.548896', 'ADD');
INSERT INTO public."History" VALUES (240, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:05:35.362105', 'ADD');
INSERT INTO public."History" VALUES (241, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:11:03.160988', 'ADD');
INSERT INTO public."History" VALUES (242, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:15:39.7728', 'ADD');
INSERT INTO public."History" VALUES (243, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:18:06.693944', 'ADD');
INSERT INTO public."History" VALUES (244, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:20:16.166532', 'ADD');
INSERT INTO public."History" VALUES (245, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:22:13.120022', 'ADD');
INSERT INTO public."History" VALUES (246, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:23:20.36682', 'ADD');
INSERT INTO public."History" VALUES (247, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:34:48.136914', 'ADD');
INSERT INTO public."History" VALUES (248, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:38:00.650282', 'ADD');
INSERT INTO public."History" VALUES (249, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:38:01.189924', 'UPDATE');
INSERT INTO public."History" VALUES (250, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:42:54.014463', 'ADD');
INSERT INTO public."History" VALUES (251, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-14 12:42:55.780908', 'UPDATE');
INSERT INTO public."History" VALUES (252, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-14 12:42:55.804843', 'UPDATE');
INSERT INTO public."History" VALUES (253, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-14 12:42:55.860695', 'UPDATE');
INSERT INTO public."History" VALUES (254, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:48:38.799193', 'ADD');
INSERT INTO public."History" VALUES (255, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:48:39.308043', 'UPDATE');
INSERT INTO public."History" VALUES (256, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:49:52.72516', 'ADD');
INSERT INTO public."History" VALUES (257, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:49:52.925513', 'UPDATE');
INSERT INTO public."History" VALUES (258, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-14 12:50:25.206433', 'ADD');
INSERT INTO public."History" VALUES (259, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:50:25.73159', 'UPDATE');
INSERT INTO public."History" VALUES (260, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:50:25.739569', 'UPDATE');
INSERT INTO public."History" VALUES (261, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:51:16.771821', 'ADD');
INSERT INTO public."History" VALUES (262, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:51:17.434362', 'UPDATE');
INSERT INTO public."History" VALUES (263, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:51:17.449323', 'UPDATE');
INSERT INTO public."History" VALUES (264, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:53:21.446028', 'ADD');
INSERT INTO public."History" VALUES (265, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:53:21.801814', 'UPDATE');
INSERT INTO public."History" VALUES (266, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:53:21.950083', 'UPDATE');
INSERT INTO public."History" VALUES (267, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 12:59:12.870777', 'ADD');
INSERT INTO public."History" VALUES (268, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:59:13.366992', 'UPDATE');
INSERT INTO public."History" VALUES (269, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 12:59:13.382949', 'UPDATE');
INSERT INTO public."History" VALUES (270, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 13:55:57.218888', 'ADD');
INSERT INTO public."History" VALUES (271, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 13:55:57.863223', 'UPDATE');
INSERT INTO public."History" VALUES (272, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-14 14:03:06.092158', 'ADD');
INSERT INTO public."History" VALUES (273, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-14 14:03:06.382674', 'UPDATE');
INSERT INTO public."History" VALUES (274, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-15 10:46:20.985755', 'ADD');
INSERT INTO public."History" VALUES (275, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:46:21.712489', 'UPDATE');
INSERT INTO public."History" VALUES (276, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:46:21.703512', 'UPDATE');
INSERT INTO public."History" VALUES (277, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-15 10:56:56.078202', 'ADD');
INSERT INTO public."History" VALUES (278, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:56:56.705523', 'UPDATE');
INSERT INTO public."History" VALUES (279, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:56:56.799272', 'UPDATE');
INSERT INTO public."History" VALUES (280, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-15 10:57:25.67984', 'ADD');
INSERT INTO public."History" VALUES (281, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:57:26.246261', 'UPDATE');
INSERT INTO public."History" VALUES (282, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:57:26.267205', 'UPDATE');
INSERT INTO public."History" VALUES (283, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-15 10:57:49.444792', 'ADD');
INSERT INTO public."History" VALUES (286, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-15 11:01:42.505953', 'UPDATE');
INSERT INTO public."History" VALUES (284, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 10:57:50.161206', 'UPDATE');
INSERT INTO public."History" VALUES (285, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-15 10:58:24.993033', 'UPDATE');
INSERT INTO public."History" VALUES (287, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-15 11:06:13.106925', 'UPDATE');
INSERT INTO public."History" VALUES (288, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:07:56.65868', 'UPDATE');
INSERT INTO public."History" VALUES (289, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-15 11:09:13.00498', 'ADD');
INSERT INTO public."History" VALUES (290, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:13.415997', 'UPDATE');
INSERT INTO public."History" VALUES (291, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-15 11:09:24.488896', 'ADD');
INSERT INTO public."History" VALUES (292, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:24.972422', 'UPDATE');
INSERT INTO public."History" VALUES (293, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:24.991372', 'UPDATE');
INSERT INTO public."History" VALUES (294, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:24.993368', 'UPDATE');
INSERT INTO public."History" VALUES (295, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-15 11:09:29.573281', 'ADD');
INSERT INTO public."History" VALUES (296, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:30.030494', 'UPDATE');
INSERT INTO public."History" VALUES (297, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:30.039339', 'UPDATE');
INSERT INTO public."History" VALUES (298, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-15 11:09:35.533792', 'ADD');
INSERT INTO public."History" VALUES (299, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:36.013158', 'UPDATE');
INSERT INTO public."History" VALUES (300, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:36.036096', 'UPDATE');
INSERT INTO public."History" VALUES (301, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:09:36.041082', 'UPDATE');
INSERT INTO public."History" VALUES (302, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:10:08.897641', 'UPDATE');
INSERT INTO public."History" VALUES (303, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:11:10.347259', 'UPDATE');
INSERT INTO public."History" VALUES (304, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:11:44.044489', 'UPDATE');
INSERT INTO public."History" VALUES (305, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:13:08.314943', 'UPDATE');
INSERT INTO public."History" VALUES (306, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:16:41.307018', 'UPDATE');
INSERT INTO public."History" VALUES (307, 'L''utilisateur Agence 11 a Delete attachement', '2023-03-15 11:22:06.576441', 'DELETE');
INSERT INTO public."History" VALUES (308, 'L''utilisateur Agence 11 a Delete attachement', '2023-03-15 11:22:08.137849', 'DELETE');
INSERT INTO public."History" VALUES (309, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:22:55.292552', 'UPDATE');
INSERT INTO public."History" VALUES (310, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:25:01.847958', 'UPDATE');
INSERT INTO public."History" VALUES (311, 'L''utilisateur Agence 11 a Delete attachement', '2023-03-15 11:25:32.086571', 'DELETE');
INSERT INTO public."History" VALUES (312, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-15 11:26:56.028369', 'ADD');
INSERT INTO public."History" VALUES (313, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:26:56.446649', 'UPDATE');
INSERT INTO public."History" VALUES (314, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-15 11:27:22.36939', 'ADD');
INSERT INTO public."History" VALUES (315, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:27:22.93005', 'UPDATE');
INSERT INTO public."History" VALUES (316, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-15 11:27:23.002455', 'UPDATE');
INSERT INTO public."History" VALUES (317, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-03-15 11:27:56.862149', 'UPDATE');
INSERT INTO public."History" VALUES (318, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-23 17:26:53.588245', 'ADD');
INSERT INTO public."History" VALUES (319, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-23 17:26:54.373499', 'UPDATE');
INSERT INTO public."History" VALUES (320, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-23 17:26:54.400428', 'UPDATE');
INSERT INTO public."History" VALUES (321, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-25 23:27:34.308184', 'ADD');
INSERT INTO public."History" VALUES (322, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-25 23:27:35.608308', 'UPDATE');
INSERT INTO public."History" VALUES (323, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-25 23:27:35.608308', 'UPDATE');
INSERT INTO public."History" VALUES (324, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-25 23:47:34.217845', 'ADD');
INSERT INTO public."History" VALUES (325, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-25 23:47:35.182611', 'UPDATE');
INSERT INTO public."History" VALUES (326, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-25 23:47:35.198236', 'UPDATE');
INSERT INTO public."History" VALUES (327, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-25 23:47:35.198236', 'UPDATE');
INSERT INTO public."History" VALUES (328, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-25 23:47:35.229473', 'UPDATE');
INSERT INTO public."History" VALUES (329, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-03-26 00:22:50.654812', 'ADD');
INSERT INTO public."History" VALUES (330, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:22:50.882713', 'UPDATE');
INSERT INTO public."History" VALUES (331, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-26 00:26:59.405773', 'ADD');
INSERT INTO public."History" VALUES (332, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:27:00.005937', 'UPDATE');
INSERT INTO public."History" VALUES (333, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:27:00.021559', 'UPDATE');
INSERT INTO public."History" VALUES (334, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:27:00.021559', 'UPDATE');
INSERT INTO public."History" VALUES (335, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:27:00.021559', 'UPDATE');
INSERT INTO public."History" VALUES (336, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-03-26 00:35:41.779435', 'ADD');
INSERT INTO public."History" VALUES (337, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:35:42.509482', 'UPDATE');
INSERT INTO public."History" VALUES (339, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:35:42.51447', 'UPDATE');
INSERT INTO public."History" VALUES (338, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:35:42.515467', 'UPDATE');
INSERT INTO public."History" VALUES (340, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:35:42.561343', 'UPDATE');
INSERT INTO public."History" VALUES (341, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-26 00:55:11.450446', 'ADD');
INSERT INTO public."History" VALUES (342, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:55:12.146491', 'UPDATE');
INSERT INTO public."History" VALUES (343, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:55:12.193356', 'UPDATE');
INSERT INTO public."History" VALUES (344, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:55:12.224597', 'UPDATE');
INSERT INTO public."History" VALUES (345, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 00:55:12.240219', 'UPDATE');
INSERT INTO public."History" VALUES (346, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-03-26 01:11:36.32153', 'ADD');
INSERT INTO public."History" VALUES (347, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 01:11:36.545355', 'UPDATE');
INSERT INTO public."History" VALUES (348, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 01:11:36.932122', 'UPDATE');
INSERT INTO public."History" VALUES (349, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 01:11:36.947743', 'UPDATE');
INSERT INTO public."History" VALUES (350, 'L''utilisateur Agence 11 a Update menu attachements', '2023-03-26 01:11:36.947743', 'UPDATE');
INSERT INTO public."History" VALUES (351, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-27 13:18:15.605542', 'ADD');
INSERT INTO public."History" VALUES (352, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-27 13:18:16.421023', 'ADD');
INSERT INTO public."History" VALUES (353, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 10:12:16.339675', 'ADD');
INSERT INTO public."History" VALUES (354, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 10:12:24.349017', 'ADD');
INSERT INTO public."History" VALUES (355, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 10:12:31.58312', 'ADD');
INSERT INTO public."History" VALUES (356, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 10:12:56.203012', 'ADD');
INSERT INTO public."History" VALUES (357, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 10:13:08.01021', 'ADD');
INSERT INTO public."History" VALUES (358, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 10:38:34.377617', 'ADD');
INSERT INTO public."History" VALUES (359, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 10:38:40.151973', 'ADD');
INSERT INTO public."History" VALUES (360, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 10:38:58.062769', 'ADD');
INSERT INTO public."History" VALUES (361, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 10:39:04.895769', 'ADD');
INSERT INTO public."History" VALUES (362, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-03-28 11:57:18.856749', 'ADD');
INSERT INTO public."History" VALUES (363, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-28 11:57:19.285546', 'UPDATE');
INSERT INTO public."History" VALUES (364, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 22:58:57.856737', 'ADD');
INSERT INTO public."History" VALUES (365, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 22:59:04.399186', 'ADD');
INSERT INTO public."History" VALUES (366, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 22:59:10.225429', 'ADD');
INSERT INTO public."History" VALUES (367, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 22:59:52.111676', 'ADD');
INSERT INTO public."History" VALUES (368, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 22:59:58.126476', 'ADD');
INSERT INTO public."History" VALUES (369, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 23:00:46.524445', 'ADD');
INSERT INTO public."History" VALUES (370, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-28 23:00:55.803196', 'ADD');
INSERT INTO public."History" VALUES (371, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 23:01:15.52412', 'ADD');
INSERT INTO public."History" VALUES (372, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-28 23:01:21.55789', 'ADD');
INSERT INTO public."History" VALUES (373, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-29 13:32:43.440083', 'ADD');
INSERT INTO public."History" VALUES (374, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-29 13:33:15.24608', 'ADD');
INSERT INTO public."History" VALUES (375, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-29 13:33:15.57594', 'UPDATE');
INSERT INTO public."History" VALUES (376, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-03-29 13:37:58.811499', 'ADD');
INSERT INTO public."History" VALUES (377, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-29 13:37:59.54431', 'UPDATE');
INSERT INTO public."History" VALUES (378, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-29 13:37:59.565262', 'UPDATE');
INSERT INTO public."History" VALUES (379, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-03-29 13:38:43.931943', 'ADD');
INSERT INTO public."History" VALUES (380, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-29 13:38:44.256877', 'UPDATE');
INSERT INTO public."History" VALUES (381, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-03-29 13:39:28.085073', 'ADD');
INSERT INTO public."History" VALUES (382, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-03-29 13:40:00.194743', 'ADD');
INSERT INTO public."History" VALUES (383, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-03-30 01:56:26.153977', 'ADD');
INSERT INTO public."History" VALUES (384, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-03-30 01:56:26.693097', 'UPDATE');
INSERT INTO public."History" VALUES (385, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-03-30 15:37:21.680752', 'ADD');
INSERT INTO public."History" VALUES (386, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-03-30 23:53:10.643554', 'ADD');
INSERT INTO public."History" VALUES (387, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-03-31 11:05:37.01226', 'ADD');
INSERT INTO public."History" VALUES (388, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-01 22:16:30.969341', 'ADD');
INSERT INTO public."History" VALUES (389, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-01 22:17:50.59577', 'ADD');
INSERT INTO public."History" VALUES (390, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-01 22:19:43.141741', 'ADD');
INSERT INTO public."History" VALUES (391, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-01 22:22:37.326471', 'ADD');
INSERT INTO public."History" VALUES (392, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-01 22:23:26.9652', 'ADD');
INSERT INTO public."History" VALUES (393, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-01 22:53:39.183861', 'ADD');
INSERT INTO public."History" VALUES (394, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-02 17:07:33.903838', 'ADD');
INSERT INTO public."History" VALUES (395, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-02 17:07:34.54429', 'UPDATE');
INSERT INTO public."History" VALUES (396, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-02 17:10:00.799533', 'ADD');
INSERT INTO public."History" VALUES (397, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-02 17:10:01.095206', 'UPDATE');
INSERT INTO public."History" VALUES (398, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-02 17:10:16.135677', 'ADD');
INSERT INTO public."History" VALUES (399, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-02 17:10:17.633374', 'UPDATE');
INSERT INTO public."History" VALUES (400, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-02 17:10:36.49069', 'ADD');
INSERT INTO public."History" VALUES (401, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-02 17:10:37.563706', 'UPDATE');
INSERT INTO public."History" VALUES (402, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-04-03 10:10:06.737998', 'ADD');
INSERT INTO public."History" VALUES (403, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:10:07.350452', 'UPDATE');
INSERT INTO public."History" VALUES (404, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:10:07.433231', 'UPDATE');
INSERT INTO public."History" VALUES (405, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:10:07.457166', 'UPDATE');
INSERT INTO public."History" VALUES (406, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:10:07.509027', 'UPDATE');
INSERT INTO public."History" VALUES (407, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-04-03 10:11:18.873605', 'ADD');
INSERT INTO public."History" VALUES (408, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:11:19.137255', 'UPDATE');
INSERT INTO public."History" VALUES (409, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:11:19.400685', 'UPDATE');
INSERT INTO public."History" VALUES (410, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-03 10:11:29.349782', 'ADD');
INSERT INTO public."History" VALUES (411, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:11:29.850263', 'UPDATE');
INSERT INTO public."History" VALUES (412, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:11:29.860237', 'UPDATE');
INSERT INTO public."History" VALUES (413, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-04-03 10:11:35.081465', 'ADD');
INSERT INTO public."History" VALUES (414, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:11:35.546469', 'UPDATE');
INSERT INTO public."History" VALUES (415, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:11:35.55245', 'UPDATE');
INSERT INTO public."History" VALUES (416, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-04-03 10:13:43.472082', 'ADD');
INSERT INTO public."History" VALUES (417, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:13:43.980551', 'UPDATE');
INSERT INTO public."History" VALUES (418, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:13:43.993515', 'UPDATE');
INSERT INTO public."History" VALUES (419, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:13:44.12101', 'UPDATE');
INSERT INTO public."History" VALUES (420, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:18:09.627231', 'ADD');
INSERT INTO public."History" VALUES (421, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:18:10.153837', 'UPDATE');
INSERT INTO public."History" VALUES (422, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:24:43.248996', 'ADD');
INSERT INTO public."History" VALUES (423, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:24:43.809529', 'UPDATE');
INSERT INTO public."History" VALUES (424, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:32:35.437196', 'ADD');
INSERT INTO public."History" VALUES (425, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:32:35.829145', 'UPDATE');
INSERT INTO public."History" VALUES (426, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:35:06.546792', 'ADD');
INSERT INTO public."History" VALUES (427, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:35:06.919794', 'UPDATE');
INSERT INTO public."History" VALUES (428, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:38:07.306636', 'ADD');
INSERT INTO public."History" VALUES (429, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:38:07.619799', 'UPDATE');
INSERT INTO public."History" VALUES (430, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:44:51.10515', 'ADD');
INSERT INTO public."History" VALUES (431, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:44:51.402373', 'UPDATE');
INSERT INTO public."History" VALUES (432, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:45:45.314743', 'ADD');
INSERT INTO public."History" VALUES (433, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:45:45.666802', 'UPDATE');
INSERT INTO public."History" VALUES (434, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-03 10:51:06.280046', 'ADD');
INSERT INTO public."History" VALUES (435, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:51:06.602184', 'UPDATE');
INSERT INTO public."History" VALUES (436, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:51:06.863785', 'UPDATE');
INSERT INTO public."History" VALUES (437, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:51:06.88872', 'UPDATE');
INSERT INTO public."History" VALUES (438, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:51:06.908666', 'UPDATE');
INSERT INTO public."History" VALUES (439, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-03 10:51:44.141763', 'ADD');
INSERT INTO public."History" VALUES (440, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:51:44.610147', 'UPDATE');
INSERT INTO public."History" VALUES (441, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-04-03 10:51:55.856228', 'ADD');
INSERT INTO public."History" VALUES (442, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:51:56.222402', 'UPDATE');
INSERT INTO public."History" VALUES (443, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-04-03 10:52:19.078049', 'ADD');
INSERT INTO public."History" VALUES (444, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 10:52:19.561832', 'UPDATE');
INSERT INTO public."History" VALUES (445, 'L''utilisateur Agence 11 a envoyé un message à ''agence@gmail.com''', '2023-04-03 10:52:40.931327', 'ADD');
INSERT INTO public."History" VALUES (446, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-03 10:55:15.826029', 'ADD');
INSERT INTO public."History" VALUES (447, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-04-03 10:57:03.044605', 'UPDATE');
INSERT INTO public."History" VALUES (448, 'L''utilisateur Risque Reporting a Update menu response attachements', '2023-04-03 10:57:51.414683', 'UPDATE');
INSERT INTO public."History" VALUES (449, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-03 10:58:15.505778', 'ADD');
INSERT INTO public."History" VALUES (450, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-03 10:58:16.003708', 'UPDATE');
INSERT INTO public."History" VALUES (451, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-03 10:59:35.072281', 'ADD');
INSERT INTO public."History" VALUES (452, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-03 11:14:30.237564', 'ADD');
INSERT INTO public."History" VALUES (453, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-03 11:14:30.846671', 'UPDATE');
INSERT INTO public."History" VALUES (454, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-03 11:14:30.92546', 'UPDATE');
INSERT INTO public."History" VALUES (455, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-03 11:14:30.92546', 'UPDATE');
INSERT INTO public."History" VALUES (456, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-03 11:14:30.954382', 'UPDATE');
INSERT INTO public."History" VALUES (457, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-03 11:14:31.04115', 'UPDATE');
INSERT INTO public."History" VALUES (458, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-03 11:28:51.932358', 'ADD');
INSERT INTO public."History" VALUES (459, 'L''utilisateur Agence 12 a envoyé un message à ''RR@gamil.com''', '2023-04-03 11:31:49.255239', 'ADD');
INSERT INTO public."History" VALUES (460, 'L''utilisateur Agence 12 a envoyé un message à ''agence@gamil.com''', '2023-04-03 11:32:02.692341', 'ADD');
INSERT INTO public."History" VALUES (461, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-03 12:04:45.357753', 'ADD');
INSERT INTO public."History" VALUES (462, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:04:45.95662', 'UPDATE');
INSERT INTO public."History" VALUES (463, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:08:06.314227', 'UPDATE');
INSERT INTO public."History" VALUES (464, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:08:12.463245', 'UPDATE');
INSERT INTO public."History" VALUES (465, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:08:15.974254', 'UPDATE');
INSERT INTO public."History" VALUES (466, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-03 12:14:35.626617', 'ADD');
INSERT INTO public."History" VALUES (467, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:14:36.351163', 'UPDATE');
INSERT INTO public."History" VALUES (468, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:14:36.363217', 'UPDATE');
INSERT INTO public."History" VALUES (469, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:14:36.368099', 'UPDATE');
INSERT INTO public."History" VALUES (470, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-03 12:14:36.371091', 'UPDATE');
INSERT INTO public."History" VALUES (471, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-04 09:06:53.520434', 'ADD');
INSERT INTO public."History" VALUES (472, 'L''utilisateur Risque Reporting a Update menu url', '2023-04-04 09:06:54.462871', 'UPDATE');
INSERT INTO public."History" VALUES (473, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:18.0611', 'UPDATE');
INSERT INTO public."History" VALUES (474, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:23.493811', 'UPDATE');
INSERT INTO public."History" VALUES (475, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:31.305292', 'UPDATE');
INSERT INTO public."History" VALUES (476, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:38.222799', 'UPDATE');
INSERT INTO public."History" VALUES (477, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:41.073182', 'UPDATE');
INSERT INTO public."History" VALUES (478, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:46.18751', 'UPDATE');
INSERT INTO public."History" VALUES (479, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:50.228705', 'UPDATE');
INSERT INTO public."History" VALUES (480, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:07:55.53951', 'UPDATE');
INSERT INTO public."History" VALUES (481, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:08:00.954036', 'UPDATE');
INSERT INTO public."History" VALUES (482, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-04 09:23:00.581795', 'ADD');
INSERT INTO public."History" VALUES (483, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:23:27.526036', 'UPDATE');
INSERT INTO public."History" VALUES (484, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:23:36.687808', 'UPDATE');
INSERT INTO public."History" VALUES (485, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:38:36.35679', 'UPDATE');
INSERT INTO public."History" VALUES (486, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:38:41.756356', 'UPDATE');
INSERT INTO public."History" VALUES (487, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:38:44.014321', 'UPDATE');
INSERT INTO public."History" VALUES (488, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:38:46.231394', 'UPDATE');
INSERT INTO public."History" VALUES (489, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:38:48.44049', 'UPDATE');
INSERT INTO public."History" VALUES (490, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:38:52.781884', 'UPDATE');
INSERT INTO public."History" VALUES (491, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:15.383287', 'DELETE');
INSERT INTO public."History" VALUES (492, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:15.634615', 'DELETE');
INSERT INTO public."History" VALUES (493, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:16.559144', 'DELETE');
INSERT INTO public."History" VALUES (494, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:20.220356', 'DELETE');
INSERT INTO public."History" VALUES (497, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:23.610295', 'DELETE');
INSERT INTO public."History" VALUES (495, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:21.297478', 'DELETE');
INSERT INTO public."History" VALUES (501, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:40:47.865076', 'UPDATE');
INSERT INTO public."History" VALUES (496, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:22.518215', 'DELETE');
INSERT INTO public."History" VALUES (498, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-04 09:40:27.719312', 'DELETE');
INSERT INTO public."History" VALUES (499, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:40:44.504061', 'UPDATE');
INSERT INTO public."History" VALUES (500, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-04 09:40:45.92227', 'UPDATE');
INSERT INTO public."History" VALUES (502, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-05 09:15:39.958434', 'ADD');
INSERT INTO public."History" VALUES (503, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-05 09:15:48.800093', 'UPDATE');
INSERT INTO public."History" VALUES (504, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-05 09:15:54.904412', 'UPDATE');
INSERT INTO public."History" VALUES (505, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-05 09:25:37.985557', 'ADD');
INSERT INTO public."History" VALUES (506, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-05 09:25:49.015917', 'UPDATE');
INSERT INTO public."History" VALUES (507, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-04-05 10:20:11.360962', 'ADD');
INSERT INTO public."History" VALUES (508, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-05 10:20:11.632743', 'UPDATE');
INSERT INTO public."History" VALUES (509, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-04-05 10:29:49.927361', 'ADD');
INSERT INTO public."History" VALUES (510, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-05 10:29:50.498181', 'UPDATE');
INSERT INTO public."History" VALUES (511, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-04-05 10:50:57.28687', 'ADD');
INSERT INTO public."History" VALUES (512, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-05 10:50:57.769907', 'UPDATE');
INSERT INTO public."History" VALUES (513, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-05 10:52:24.068341', 'ADD');
INSERT INTO public."History" VALUES (514, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-05 10:52:24.362247', 'UPDATE');
INSERT INTO public."History" VALUES (515, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-05 10:52:24.545259', 'UPDATE');
INSERT INTO public."History" VALUES (516, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-05 11:49:09.109182', 'UPDATE');
INSERT INTO public."History" VALUES (517, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-04-07 10:08:43.950456', 'ADD');
INSERT INTO public."History" VALUES (518, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 10:08:44.625726', 'UPDATE');
INSERT INTO public."History" VALUES (519, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 10:08:44.775325', 'UPDATE');
INSERT INTO public."History" VALUES (520, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-04-07 11:43:21.994467', 'ADD');
INSERT INTO public."History" VALUES (521, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:43:22.898414', 'UPDATE');
INSERT INTO public."History" VALUES (522, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-07 11:51:54.825058', 'ADD');
INSERT INTO public."History" VALUES (523, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:51:55.198494', 'UPDATE');
INSERT INTO public."History" VALUES (524, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:51:55.300221', 'UPDATE');
INSERT INTO public."History" VALUES (525, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement Carte''', '2023-04-07 11:55:26.438082', 'ADD');
INSERT INTO public."History" VALUES (526, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:55:27.132343', 'UPDATE');
INSERT INTO public."History" VALUES (527, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:55:27.21179', 'UPDATE');
INSERT INTO public."History" VALUES (528, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:55:27.238717', 'UPDATE');
INSERT INTO public."History" VALUES (529, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 11:55:27.242707', 'UPDATE');
INSERT INTO public."History" VALUES (530, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-04-07 12:13:47.555059', 'ADD');
INSERT INTO public."History" VALUES (531, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 12:13:47.836307', 'UPDATE');
INSERT INTO public."History" VALUES (532, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement SED''', '2023-04-07 12:40:31.359163', 'ADD');
INSERT INTO public."History" VALUES (533, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 12:40:31.604508', 'UPDATE');
INSERT INTO public."History" VALUES (534, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-04-07 12:47:31.967067', 'ADD');
INSERT INTO public."History" VALUES (535, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 12:47:32.540028', 'UPDATE');
INSERT INTO public."History" VALUES (536, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-07 12:52:53.443231', 'ADD');
INSERT INTO public."History" VALUES (537, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 12:52:53.648734', 'UPDATE');
INSERT INTO public."History" VALUES (538, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-07 12:58:06.320938', 'ADD');
INSERT INTO public."History" VALUES (539, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 12:58:06.620148', 'UPDATE');
INSERT INTO public."History" VALUES (540, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-07 13:00:20.503208', 'ADD');
INSERT INTO public."History" VALUES (541, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 13:00:20.943125', 'UPDATE');
INSERT INTO public."History" VALUES (542, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-04-07 13:03:24.779642', 'ADD');
INSERT INTO public."History" VALUES (543, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-07 13:03:25.107968', 'UPDATE');
INSERT INTO public."History" VALUES (544, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-07 13:03:25.252582', 'UPDATE');
INSERT INTO public."History" VALUES (545, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-07 13:05:41.885758', 'ADD');
INSERT INTO public."History" VALUES (546, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 13:05:42.272504', 'UPDATE');
INSERT INTO public."History" VALUES (547, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-07 13:22:43.24807', 'ADD');
INSERT INTO public."History" VALUES (548, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-07 13:22:43.568332', 'UPDATE');
INSERT INTO public."History" VALUES (549, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-07 14:07:31.831795', 'ADD');
INSERT INTO public."History" VALUES (550, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-07 14:07:32.213074', 'UPDATE');
INSERT INTO public."History" VALUES (551, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 09:59:53.91629', 'ADD');
INSERT INTO public."History" VALUES (552, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 09:59:54.384464', 'UPDATE');
INSERT INTO public."History" VALUES (553, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 10:25:28.731143', 'ADD');
INSERT INTO public."History" VALUES (554, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 10:25:30.514385', 'UPDATE');
INSERT INTO public."History" VALUES (555, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-09 10:32:03.89186', 'ADD');
INSERT INTO public."History" VALUES (556, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-09 10:32:04.376562', 'UPDATE');
INSERT INTO public."History" VALUES (557, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 10:40:10.718961', 'ADD');
INSERT INTO public."History" VALUES (558, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 10:40:11.134849', 'UPDATE');
INSERT INTO public."History" VALUES (559, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 10:56:09.832079', 'ADD');
INSERT INTO public."History" VALUES (560, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 10:56:10.528504', 'UPDATE');
INSERT INTO public."History" VALUES (561, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 11:04:51.727421', 'ADD');
INSERT INTO public."History" VALUES (562, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 11:04:52.072496', 'UPDATE');
INSERT INTO public."History" VALUES (563, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 11:12:50.671339', 'ADD');
INSERT INTO public."History" VALUES (564, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 11:12:51.045379', 'UPDATE');
INSERT INTO public."History" VALUES (565, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 11:17:54.524018', 'ADD');
INSERT INTO public."History" VALUES (566, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 11:17:54.938294', 'UPDATE');
INSERT INTO public."History" VALUES (568, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 11:24:04.823803', 'UPDATE');
INSERT INTO public."History" VALUES (567, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 11:24:04.450754', 'ADD');
INSERT INTO public."History" VALUES (569, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 11:26:22.979634', 'ADD');
INSERT INTO public."History" VALUES (574, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-09 11:34:20.507164', 'UPDATE');
INSERT INTO public."History" VALUES (570, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 11:26:23.281987', 'UPDATE');
INSERT INTO public."History" VALUES (571, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 11:28:08.037441', 'ADD');
INSERT INTO public."History" VALUES (572, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 11:28:08.808308', 'UPDATE');
INSERT INTO public."History" VALUES (575, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-09 11:35:53.736277', 'ADD');
INSERT INTO public."History" VALUES (573, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-09 11:34:18.569489', 'ADD');
INSERT INTO public."History" VALUES (576, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-09 11:35:54.09597', 'UPDATE');
INSERT INTO public."History" VALUES (577, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 12:23:18.10218', 'ADD');
INSERT INTO public."History" VALUES (578, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-09 12:23:18.448332', 'UPDATE');
INSERT INTO public."History" VALUES (579, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-09 22:46:01.839321', 'ADD');
INSERT INTO public."History" VALUES (580, 'L''utilisateur Agence 11 a envoyé un message à ''agence@gmail.com''', '2023-04-10 09:10:37.434959', 'ADD');
INSERT INTO public."History" VALUES (581, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-10 09:11:07.454565', 'ADD');
INSERT INTO public."History" VALUES (582, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-10 09:11:22.460498', 'ADD');
INSERT INTO public."History" VALUES (583, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-10 09:11:33.339164', 'ADD');
INSERT INTO public."History" VALUES (584, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-10 11:27:46.402292', 'ADD');
INSERT INTO public."History" VALUES (585, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-10 11:29:36.330309', 'ADD');
INSERT INTO public."History" VALUES (586, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement Carte''', '2023-04-10 12:02:14.106811', 'ADD');
INSERT INTO public."History" VALUES (587, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-10 12:02:14.704819', 'UPDATE');
INSERT INTO public."History" VALUES (588, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gamil.com''', '2023-04-10 12:28:34.139726', 'ADD');
INSERT INTO public."History" VALUES (589, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-10 12:29:30.116656', 'ADD');
INSERT INTO public."History" VALUES (590, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-10 12:30:22.499637', 'ADD');
INSERT INTO public."History" VALUES (591, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement SED''', '2023-04-10 12:36:26.049012', 'ADD');
INSERT INTO public."History" VALUES (592, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-10 12:36:26.595189', 'UPDATE');
INSERT INTO public."History" VALUES (593, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-10 12:36:26.603168', 'UPDATE');
INSERT INTO public."History" VALUES (594, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-10 12:36:26.6291', 'UPDATE');
INSERT INTO public."History" VALUES (595, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-10 12:37:47.275928', 'ADD');
INSERT INTO public."History" VALUES (596, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-10 12:37:47.76024', 'UPDATE');
INSERT INTO public."History" VALUES (597, 'L''utilisateur Agence 11 a passé une réclamation de type ''Déclassement T24''', '2023-04-10 12:38:55.672095', 'ADD');
INSERT INTO public."History" VALUES (598, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-10 12:38:56.038268', 'UPDATE');
INSERT INTO public."History" VALUES (599, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-10 12:39:26.039116', 'ADD');
INSERT INTO public."History" VALUES (600, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-10 12:39:26.43274', 'UPDATE');
INSERT INTO public."History" VALUES (601, 'L''utilisateur Agence 11 a envoyé un message à ''RR@gmail.com''', '2023-04-10 12:39:52.783092', 'ADD');
INSERT INTO public."History" VALUES (602, 'L''utilisateur Agence 11 a Update menu attachements', '2023-04-10 12:39:53.235925', 'UPDATE');
INSERT INTO public."History" VALUES (603, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-10 14:04:54.101411', 'ADD');
INSERT INTO public."History" VALUES (604, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-10 14:06:19.603114', 'ADD');
INSERT INTO public."History" VALUES (605, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-10 14:06:32.459045', 'UPDATE');
INSERT INTO public."History" VALUES (606, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-10 14:06:33.752587', 'UPDATE');
INSERT INTO public."History" VALUES (607, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-10 14:07:43.775496', 'ADD');
INSERT INTO public."History" VALUES (608, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-10 14:07:56.332445', 'UPDATE');
INSERT INTO public."History" VALUES (609, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-10 23:03:40.736024', 'ADD');
INSERT INTO public."History" VALUES (610, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-10 23:03:58.615934', 'UPDATE');
INSERT INTO public."History" VALUES (611, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-10 23:04:00.638093', 'UPDATE');
INSERT INTO public."History" VALUES (612, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-11 09:08:20.57118', 'ADD');
INSERT INTO public."History" VALUES (613, 'L''utilisateur Risque Reporting a Update menu url', '2023-04-11 09:08:21.661896', 'UPDATE');
INSERT INTO public."History" VALUES (614, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-11 09:08:30.635093', 'UPDATE');
INSERT INTO public."History" VALUES (615, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-11 09:48:25.449487', 'ADD');
INSERT INTO public."History" VALUES (616, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-11 09:51:15.296287', 'ADD');
INSERT INTO public."History" VALUES (617, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-11 09:52:37.796523', 'UPDATE');
INSERT INTO public."History" VALUES (618, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-11 10:14:00.949845', 'ADD');
INSERT INTO public."History" VALUES (619, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-11 10:15:46.803219', 'UPDATE');
INSERT INTO public."History" VALUES (620, 'L''utilisateur Risque Reporting a Add new composant', '2023-04-11 11:16:01.707528', 'ADD');
INSERT INTO public."History" VALUES (621, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-13 12:58:32.082977', 'UPDATE');
INSERT INTO public."History" VALUES (622, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-24 16:59:44.803634', 'UPDATE');
INSERT INTO public."History" VALUES (623, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-24 16:59:47.810373', 'UPDATE');
INSERT INTO public."History" VALUES (624, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-24 16:59:55.823035', 'UPDATE');
INSERT INTO public."History" VALUES (625, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-25 15:32:13.697835', 'ADD');
INSERT INTO public."History" VALUES (626, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-25 15:32:52.318506', 'UPDATE');
INSERT INTO public."History" VALUES (627, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-26 23:42:15.315803', 'UPDATE');
INSERT INTO public."History" VALUES (628, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-26 23:42:16.14388', 'UPDATE');
INSERT INTO public."History" VALUES (629, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-27 17:07:21.041891', 'ADD');
INSERT INTO public."History" VALUES (630, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-27 17:08:00.267604', 'UPDATE');
INSERT INTO public."History" VALUES (631, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-27 17:12:55.393978', 'ADD');
INSERT INTO public."History" VALUES (632, 'L''utilisateur Risque Reporting a Update menu url', '2023-04-27 17:12:56.436313', 'UPDATE');
INSERT INTO public."History" VALUES (633, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-27 17:13:39.00831', 'UPDATE');
INSERT INTO public."History" VALUES (634, 'L''utilisateur Risque Reporting a Add new composant', '2023-04-27 17:14:24.32144', 'ADD');
INSERT INTO public."History" VALUES (635, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-27 22:55:24.653754', 'UPDATE');
INSERT INTO public."History" VALUES (636, 'L''utilisateur Agence 13 a passé une réclamation de type ''Déclassement T24''', '2023-04-28 09:17:53.564873', 'ADD');
INSERT INTO public."History" VALUES (637, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 09:18:00.513389', 'UPDATE');
INSERT INTO public."History" VALUES (638, 'L''utilisateur Agence 13 a passé une réclamation de type ''Déclassement T24''', '2023-04-28 09:19:56.725562', 'ADD');
INSERT INTO public."History" VALUES (639, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 09:20:00.297982', 'UPDATE');
INSERT INTO public."History" VALUES (640, 'L''utilisateur Risque Reporting a Delete menu', '2023-04-28 09:21:50.771412', 'DELETE');
INSERT INTO public."History" VALUES (641, 'L''utilisateur Risque Reporting a Update menu composants', '2023-04-28 09:40:30.735429', 'UPDATE');
INSERT INTO public."History" VALUES (642, 'L''utilisateur Risque Reporting a Update menu composants', '2023-04-28 09:41:27.372486', 'UPDATE');
INSERT INTO public."History" VALUES (643, 'L''utilisateur Risque Reporting a Delete composant', '2023-04-28 09:59:33.906824', 'DELETE');
INSERT INTO public."History" VALUES (644, 'L''utilisateur Risque Reporting a Delete composant', '2023-04-28 10:00:01.629678', 'DELETE');
INSERT INTO public."History" VALUES (645, 'L''utilisateur Risque Reporting a Update menu composants', '2023-04-28 10:00:47.216644', 'UPDATE');
INSERT INTO public."History" VALUES (646, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-04-28 11:56:39.30489', 'ADD');
INSERT INTO public."History" VALUES (647, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:56:44.481729', 'UPDATE');
INSERT INTO public."History" VALUES (648, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:56:44.493698', 'UPDATE');
INSERT INTO public."History" VALUES (649, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:56:44.540572', 'UPDATE');
INSERT INTO public."History" VALUES (650, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:56:44.614374', 'UPDATE');
INSERT INTO public."History" VALUES (651, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:56:44.638311', 'UPDATE');
INSERT INTO public."History" VALUES (652, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:56:44.742034', 'UPDATE');
INSERT INTO public."History" VALUES (653, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-28 11:58:02.142528', 'ADD');
INSERT INTO public."History" VALUES (654, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:58:04.850104', 'UPDATE');
INSERT INTO public."History" VALUES (655, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:58:05.194082', 'UPDATE');
INSERT INTO public."History" VALUES (656, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:58:05.205053', 'UPDATE');
INSERT INTO public."History" VALUES (657, 'L''utilisateur Risque Reporting a envoyé un message à ''RR@gmail.com''', '2023-04-28 11:58:58.743484', 'ADD');
INSERT INTO public."History" VALUES (658, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:59:01.160648', 'UPDATE');
INSERT INTO public."History" VALUES (659, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 11:59:01.516154', 'UPDATE');
INSERT INTO public."History" VALUES (660, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:19.165094', 'UPDATE');
INSERT INTO public."History" VALUES (661, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:19.436727', 'UPDATE');
INSERT INTO public."History" VALUES (662, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:19.460662', 'UPDATE');
INSERT INTO public."History" VALUES (663, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:19.961905', 'UPDATE');
INSERT INTO public."History" VALUES (664, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:20.134748', 'UPDATE');
INSERT INTO public."History" VALUES (665, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:20.417853', 'UPDATE');
INSERT INTO public."History" VALUES (666, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:20.87389', 'UPDATE');
INSERT INTO public."History" VALUES (668, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:21.139741', 'UPDATE');
INSERT INTO public."History" VALUES (667, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:21.139741', 'UPDATE');
INSERT INTO public."History" VALUES (669, 'L''utilisateur Risque Reporting a Update menu name', '2023-04-28 12:01:21.31028', 'UPDATE');
INSERT INTO public."History" VALUES (670, 'L''utilisateur Risque Reporting a envoyé un message à ''agence@gmail.com''', '2023-04-28 12:35:43.419335', 'ADD');
INSERT INTO public."History" VALUES (671, 'L''utilisateur Risque Reporting a envoyé un message à ''agence13@gmail.com''', '2023-04-28 12:44:10.040231', 'ADD');
INSERT INTO public."History" VALUES (672, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 12:44:13.499116', 'UPDATE');
INSERT INTO public."History" VALUES (673, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 12:44:13.720525', 'UPDATE');
INSERT INTO public."History" VALUES (674, 'L''utilisateur Risque Reporting a envoyé un message à ''agence13@gmail.com''', '2023-04-28 13:04:03.447914', 'ADD');
INSERT INTO public."History" VALUES (675, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 13:04:10.209806', 'UPDATE');
INSERT INTO public."History" VALUES (676, 'L''utilisateur Agence 13 a envoyé un message à ''RR@gmail.com''', '2023-04-28 13:26:54.456155', 'ADD');
INSERT INTO public."History" VALUES (677, 'L''utilisateur Risque Reporting a envoyé un message à ''agence13@gmail.com''', '2023-04-28 13:29:08.061116', 'ADD');
INSERT INTO public."History" VALUES (678, 'L''utilisateur Risque Reporting a envoyé un message à ''region@gmail.com''', '2023-04-28 13:32:24.722259', 'ADD');
INSERT INTO public."History" VALUES (679, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 13:32:27.338288', 'UPDATE');
INSERT INTO public."History" VALUES (680, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 15:14:47.374066', 'UPDATE');
INSERT INTO public."History" VALUES (681, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 15:14:49.923598', 'UPDATE');
INSERT INTO public."History" VALUES (682, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 15:14:56.66092', 'UPDATE');
INSERT INTO public."History" VALUES (683, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 15:14:57.855899', 'UPDATE');
INSERT INTO public."History" VALUES (684, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 15:15:00.128982', 'UPDATE');
INSERT INTO public."History" VALUES (685, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 15:15:01.272416', 'UPDATE');
INSERT INTO public."History" VALUES (686, 'L''utilisateur Agence 13 a passé une réclamation de type ''Déclassement T24''', '2023-04-28 15:59:16.997923', 'ADD');
INSERT INTO public."History" VALUES (687, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 15:59:21.393842', 'UPDATE');
INSERT INTO public."History" VALUES (688, 'L''utilisateur Agence 13 a passé une réclamation de type ''Déclassement SED''', '2023-04-28 16:15:48.466693', 'ADD');
INSERT INTO public."History" VALUES (689, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:15:52.334172', 'UPDATE');
INSERT INTO public."History" VALUES (690, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:15:52.390022', 'UPDATE');
INSERT INTO public."History" VALUES (691, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:15:52.580513', 'UPDATE');
INSERT INTO public."History" VALUES (692, 'L''utilisateur Agence 13 a passé une réclamation de type ''Déclassement SED''', '2023-04-28 16:25:04.331978', 'ADD');
INSERT INTO public."History" VALUES (693, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:25:08.178055', 'UPDATE');
INSERT INTO public."History" VALUES (694, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:25:08.198999', 'UPDATE');
INSERT INTO public."History" VALUES (695, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:25:08.24687', 'UPDATE');
INSERT INTO public."History" VALUES (696, 'L''utilisateur Risque Reporting a envoyé un message à ''agence13@gmail.com''', '2023-04-28 16:25:49.693391', 'ADD');
INSERT INTO public."History" VALUES (697, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 16:25:52.45547', 'UPDATE');
INSERT INTO public."History" VALUES (698, 'L''utilisateur Risque Reporting a envoyé un message à ''agence13@gmail.com''', '2023-04-28 16:26:24.105464', 'ADD');
INSERT INTO public."History" VALUES (699, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-28 16:26:26.809874', 'UPDATE');
INSERT INTO public."History" VALUES (700, 'L''utilisateur Agence 13 a envoyé un message à ''RR@gmail.com''', '2023-04-28 16:29:32.049526', 'ADD');
INSERT INTO public."History" VALUES (701, 'L''utilisateur Agence 13 a Update menu attachements', '2023-04-28 16:29:35.203621', 'UPDATE');
INSERT INTO public."History" VALUES (702, 'L''utilisateur Risque Reporting a envoyé un message à ''agence13@gmail.com''', '2023-04-28 16:29:55.879237', 'ADD');
INSERT INTO public."History" VALUES (703, 'L''utilisateur Risque Reporting a Add profile', '2023-04-28 17:23:30.06584', 'ADD');
INSERT INTO public."History" VALUES (704, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-28 17:24:26.397123', 'ADD');
INSERT INTO public."History" VALUES (705, 'L''utilisateur Risque Reporting a Update menu url', '2023-04-28 17:24:27.053845', 'UPDATE');
INSERT INTO public."History" VALUES (706, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-28 17:24:40.416252', 'UPDATE');
INSERT INTO public."History" VALUES (707, 'L''utilisateur Risque Reporting a Update menu composants', '2023-04-28 17:25:59.049343', 'UPDATE');
INSERT INTO public."History" VALUES (708, 'L''utilisateur Risque Reporting a Delete menu', '2023-04-29 08:15:40.905849', 'DELETE');
INSERT INTO public."History" VALUES (709, 'L''utilisateur Risque Reporting a Delete menu', '2023-04-29 08:16:09.603879', 'DELETE');
INSERT INTO public."History" VALUES (710, 'L''utilisateur Risque Reporting a Delete menu', '2023-04-29 08:17:41.806055', 'DELETE');
INSERT INTO public."History" VALUES (711, 'L''utilisateur Risque Reporting a Delete menu', '2023-04-29 08:18:13.023172', 'DELETE');
INSERT INTO public."History" VALUES (712, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-29 21:08:55.77384', 'ADD');
INSERT INTO public."History" VALUES (713, 'L''utilisateur Risque Reporting a Update menu url', '2023-04-29 21:08:56.568442', 'UPDATE');
INSERT INTO public."History" VALUES (714, 'L''utilisateur Risque Reporting a Add new menu', '2023-04-29 22:42:07.182761', 'ADD');
INSERT INTO public."History" VALUES (715, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-29 22:43:28.173866', 'UPDATE');
INSERT INTO public."History" VALUES (716, 'L''utilisateur Risque Reporting a Delete permission', '2023-04-29 22:44:39.272992', 'DELETE');
INSERT INTO public."History" VALUES (717, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-04-29 22:44:50.668735', 'UPDATE');
INSERT INTO public."History" VALUES (718, 'L''utilisateur Risque Reporting a passé une réclamation de type ''Déclassement T24''', '2023-04-29 23:16:29.126622', 'ADD');
INSERT INTO public."History" VALUES (719, 'L''utilisateur Risque Reporting a Update menu attachements', '2023-04-29 23:16:34.24616', 'UPDATE');
INSERT INTO public."History" VALUES (720, 'L''utilisateur Risque Reporting a Add new menu', '2023-05-01 00:27:05.405408', 'ADD');
INSERT INTO public."History" VALUES (721, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-05-01 00:27:22.273158', 'UPDATE');
INSERT INTO public."History" VALUES (722, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 18:40:50.285413', 'ADD');
INSERT INTO public."History" VALUES (723, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 18:42:31.944757', 'ADD');
INSERT INTO public."History" VALUES (724, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 18:42:52.888576', 'ADD');
INSERT INTO public."History" VALUES (725, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 18:44:15.364448', 'ADD');
INSERT INTO public."History" VALUES (726, 'L''utilisateur Agence 13 a Update menu attachements', '2023-05-01 18:46:45.18402', 'UPDATE');
INSERT INTO public."History" VALUES (727, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:01:23.403998', 'ADD');
INSERT INTO public."History" VALUES (728, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:01:33.735972', 'ADD');
INSERT INTO public."History" VALUES (729, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:02:17.712756', 'ADD');
INSERT INTO public."History" VALUES (730, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:03:00.186004', 'ADD');
INSERT INTO public."History" VALUES (731, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:03:07.803337', 'ADD');
INSERT INTO public."History" VALUES (732, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:04:03.642124', 'ADD');
INSERT INTO public."History" VALUES (733, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:04:03.66011', 'ADD');
INSERT INTO public."History" VALUES (734, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:04:52.670199', 'ADD');
INSERT INTO public."History" VALUES (735, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:11:00.030324', 'ADD');
INSERT INTO public."History" VALUES (736, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:11:00.135045', 'ADD');
INSERT INTO public."History" VALUES (737, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:19:37.781733', 'ADD');
INSERT INTO public."History" VALUES (738, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:19:37.78273', 'ADD');
INSERT INTO public."History" VALUES (739, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:24:34.478734', 'ADD');
INSERT INTO public."History" VALUES (740, 'L''utilisateur Agence 13 a passé une réclamation de classification ''', '2023-05-01 19:24:34.923544', 'ADD');
INSERT INTO public."History" VALUES (741, 'L''utilisateur Risque Reporting a Delete permission', '2023-05-01 22:33:00.05293', 'DELETE');
INSERT INTO public."History" VALUES (742, 'L''utilisateur Risque Reporting a Delete permission', '2023-05-01 22:33:08.113428', 'DELETE');
INSERT INTO public."History" VALUES (743, 'L''utilisateur Risque Reporting a Delete permission', '2023-05-01 22:33:13.806435', 'DELETE');
INSERT INTO public."History" VALUES (744, 'L''utilisateur Risque Reporting a Delete permission', '2023-05-01 22:33:22.982443', 'DELETE');
INSERT INTO public."History" VALUES (745, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-05-01 22:36:12.522953', 'UPDATE');
INSERT INTO public."History" VALUES (746, 'L''utilisateur Risque Reporting a Delete permission', '2023-05-01 22:37:07.058995', 'DELETE');
INSERT INTO public."History" VALUES (747, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-05-01 22:37:13.859041', 'UPDATE');
INSERT INTO public."History" VALUES (748, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-05-01 22:37:16.459744', 'UPDATE');
INSERT INTO public."History" VALUES (749, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-05-01 22:37:16.869469', 'UPDATE');
INSERT INTO public."History" VALUES (750, 'L''utilisateur Risque Reporting a Update profile permissions', '2023-05-01 22:37:17.581179', 'UPDATE');


--
-- TOC entry 3834 (class 0 OID 100067)
-- Dependencies: 289
-- Data for Name: Menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Menu" VALUES (186, true, true, 'cilUser', NULL, 1, 'Gestion des profils', '/base/profils');
INSERT INTO public."Menu" VALUES (191, true, true, 'cilLan', NULL, 1, 'Classification', '/base/classification');
INSERT INTO public."Menu" VALUES (187, true, true, 'cilSpeedometer', NULL, 1, 'Dashboard', '/dashboard');
INSERT INTO public."Menu" VALUES (197, true, true, NULL, 190, 3, 'Classification', '/base/menu/196');
INSERT INTO public."Menu" VALUES (190, false, true, 'cilInbox', 188, 2, 'Inbox', '/base/chat');
INSERT INTO public."Menu" VALUES (188, false, true, 'cilEnvelopeOpen', NULL, 1, 'Email', '/base/chat');
INSERT INTO public."Menu" VALUES (192, true, true, 'cilCloudDownload', NULL, 1, 'Centre de partage', '/base/centerDePartage');
INSERT INTO public."Menu" VALUES (182, true, true, 'cilPencil', NULL, 1, 'Nouvelle réclamation', '/base/composemessage');
INSERT INTO public."Menu" VALUES (151, true, true, 'cilCode', NULL, 1, 'Fonctions', '/base/tables');
INSERT INTO public."Menu" VALUES (198, true, true, 'cilFilter', NULL, 1, 'Filtre', '/base/filter');
INSERT INTO public."Menu" VALUES (183, true, true, 'cilBellExclamation', NULL, 1, 'Réclamations non traitées', '/base/untreatedReclamations');
INSERT INTO public."Menu" VALUES (184, true, true, 'cilPeople', NULL, 1, 'Gestion des utilisateurs', '/base/users');
INSERT INTO public."Menu" VALUES (181, true, true, 'cilBell', NULL, 1, 'Réclamations traitées', '/base/reclamations');
INSERT INTO public."Menu" VALUES (185, true, true, 'cilListNumbered', NULL, 1, 'Configuration du sidebar', '/base/configuration');


--
-- TOC entry 3847 (class 0 OID 125103)
-- Dependencies: 302
-- Data for Name: Menu_composants; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3858 (class 0 OID 174277)
-- Dependencies: 313
-- Data for Name: Message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Message" VALUES (56, '', '', NULL, 'Chat1', 'Sent', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'Bonjourrrr', '2023-04-28 13:04:03.400622', 'MESSAGE', NULL, NULL);
INSERT INTO public."Message" VALUES (57, '', '', 56, 'Chat1', 'Déposée', 'RR@gmail.com', 'agence13@gmail.com', NULL, 'Reponse 1', '2023-04-28 13:26:54.424238', 'ReMESSAGE', NULL, NULL);
INSERT INTO public."Message" VALUES (58, '', '', 57, 'Chat1', 'Déposée', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'reponse 1.1', '2023-04-28 13:29:08.055131', 'ReMESSAGE', NULL, NULL);
INSERT INTO public."Message" VALUES (59, '', '', NULL, 'Chat2', 'Sent', 'region@gmail.com', 'RR@gmail.com', NULL, 'Bonjour Region', '2023-04-28 13:32:24.710188', 'MESSAGE', NULL, NULL);
INSERT INTO public."Message" VALUES (61, '852', '1111111', NULL, 'Déclassement SED', 'Déposée', 'RR@gamil.com', 'agence13@gmail.com', NULL, 'reclamation 2', '2023-04-28 16:15:48.399872', 'RECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (63, '11111', '66', 62, 'Déclassement SED', 'Déposée', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'validée', '2023-04-28 16:25:49.685412', 'ReRECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (62, '11111', '66', NULL, 'Déclassement SED', 'Traitée', 'RR@gamil.com', 'agence13@gmail.com', 'Validée', 'reclamation 3', '2023-04-28 16:25:04.234715', 'RECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (64, '456258', '54848', 60, 'Déclassement T24', 'Traitée', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'Refusée', '2023-04-28 16:26:24.100475', 'ReRECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (65, '456258', '54848', 64, 'Déclassement T24', 'Traitée', 'RR@gmail.com', 'agence13@gmail.com', NULL, 'reponse 2', '2023-04-28 16:29:32.04454', 'ReRECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (66, '456258', '54848', 65, 'Déclassement T24', 'Déposée', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'manque', '2023-04-28 16:29:55.36508', 'ReRECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (60, '456258', '54848', NULL, 'Déclassement T24', 'Traitée', 'RR@gamil.com', 'agence13@gmail.com', 'Validée', 'reclamation 1', '2023-04-28 15:59:16.930498', 'RECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (67, '11111', '1111111', NULL, 'Déclassement T24', 'Déposée', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'heyyy', '2023-04-29 23:16:28.734454', 'RECLAMATION', NULL, NULL);
INSERT INTO public."Message" VALUES (95, 'noussa', 'bbb', NULL, NULL, 'En attente', 'RR@gmail.com', 'agence12@gmail.com', NULL, 'textttttttt', '2023-05-01 19:04:52', 'CLASSIFICATION', NULL, NULL);
INSERT INTO public."Message" VALUES (99, 'ons', 'fff', NULL, NULL, 'Classé', 'RR@gmail.com', 'agence12@gmail.com', 'Accepté', 'textttttttt', '2023-05-01 19:04:52', 'CLASSIFICATION', 1, 'M');
INSERT INTO public."Message" VALUES (96, 'ons', 'ddd', NULL, NULL, 'En attente', 'RR@gmail.com', 'agence12@gmail.com', 'Refusé', 'textttttttt', '2023-05-01 19:04:52', 'CLASSIFICATION', NULL, NULL);
INSERT INTO public."Message" VALUES (100, 'ons', 'eee', NULL, NULL, 'Classé', 'RR@gmail.com', 'agence12@gmail.com', 'Accepté', 'textttttttt', '2023-05-01 19:04:52', 'CLASSIFICATION', 2, 'M');
INSERT INTO public."Message" VALUES (102, 'noussa', 'ggg', NULL, NULL, 'En attente', 'RR@gmail.com', 'agence13@gmail.com', NULL, 'texteeeeeee', '2023-05-01 19:04:52', 'CLASSIFICATION', NULL, NULL);
INSERT INTO public."Message" VALUES (54, '', '', 39, 'reponse4 Message1', 'Déposée', 'agence@gmail.com', 'RR@gmail.com', NULL, 'bonjour', '2023-04-28 12:35:43.36976', 'ReMESSAGE', NULL, NULL);
INSERT INTO public."Message" VALUES (55, '456258', '54848', 50, 'Déclassement T24', 'Déposée', 'agence13@gmail.com', 'RR@gmail.com', NULL, 'bonjour bonjour bonjour bonjour bonjour bonjour bonjour bonjour bonjour bonjour bonjour', '2023-04-28 12:44:10.012305', 'ReRECLAMATION', NULL, NULL);


--
-- TOC entry 3859 (class 0 OID 174285)
-- Dependencies: 314
-- Data for Name: Message_attachements; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Message_attachements" VALUES (55, 339);
INSERT INTO public."Message_attachements" VALUES (55, 340);
INSERT INTO public."Message_attachements" VALUES (56, 341);
INSERT INTO public."Message_attachements" VALUES (59, 342);
INSERT INTO public."Message_attachements" VALUES (60, 345);
INSERT INTO public."Message_attachements" VALUES (61, 347);
INSERT INTO public."Message_attachements" VALUES (61, 346);
INSERT INTO public."Message_attachements" VALUES (61, 348);
INSERT INTO public."Message_attachements" VALUES (62, 350);
INSERT INTO public."Message_attachements" VALUES (62, 351);
INSERT INTO public."Message_attachements" VALUES (62, 349);
INSERT INTO public."Message_attachements" VALUES (63, 352);
INSERT INTO public."Message_attachements" VALUES (64, 353);
INSERT INTO public."Message_attachements" VALUES (65, 354);
INSERT INTO public."Message_attachements" VALUES (67, 356);


--
-- TOC entry 3775 (class 0 OID 58309)
-- Dependencies: 230
-- Data for Name: P_TYP_ENG_BCT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3839 (class 0 OID 108553)
-- Dependencies: 294
-- Data for Name: Permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Permissions" VALUES (384, 183);
INSERT INTO public."Permissions" VALUES (385, 183);
INSERT INTO public."Permissions" VALUES (386, 184);
INSERT INTO public."Permissions" VALUES (387, 185);
INSERT INTO public."Permissions" VALUES (388, 186);
INSERT INTO public."Permissions" VALUES (389, 187);
INSERT INTO public."Permissions" VALUES (390, 187);
INSERT INTO public."Permissions" VALUES (392, 190);
INSERT INTO public."Permissions" VALUES (393, 191);
INSERT INTO public."Permissions" VALUES (394, 191);
INSERT INTO public."Permissions" VALUES (395, 191);
INSERT INTO public."Permissions" VALUES (396, 191);
INSERT INTO public."Permissions" VALUES (397, 191);
INSERT INTO public."Permissions" VALUES (411, 197);
INSERT INTO public."Permissions" VALUES (414, 188);
INSERT INTO public."Permissions" VALUES (415, 192);
INSERT INTO public."Permissions" VALUES (416, 182);
INSERT INTO public."Permissions" VALUES (417, 151);
INSERT INTO public."Permissions" VALUES (418, 198);
INSERT INTO public."Permissions" VALUES (373, 181);
INSERT INTO public."Permissions" VALUES (376, 181);


--
-- TOC entry 3837 (class 0 OID 108447)
-- Dependencies: 292
-- Data for Name: Profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Profile" VALUES (1, 'AGENCE');
INSERT INTO public."Profile" VALUES (4, 'NewUser');
INSERT INTO public."Profile" VALUES (6, 'PCB');
INSERT INTO public."Profile" VALUES (7, 'PBD');
INSERT INTO public."Profile" VALUES (8, 'REGION');
INSERT INTO public."Profile" VALUES (9, 'ZONE');
INSERT INTO public."Profile" VALUES (10, 'GROUPE');
INSERT INTO public."Profile" VALUES (11, 'CHARGE D''AFFAIRES');
INSERT INTO public."Profile" VALUES (12, 'RISQUE CREDIT');
INSERT INTO public."Profile" VALUES (13, 'RISQUE REPORTING');


--
-- TOC entry 3840 (class 0 OID 108618)
-- Dependencies: 295
-- Data for Name: Profile_permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Profile_permissions" VALUES (1, 373);
INSERT INTO public."Profile_permissions" VALUES (13, 376);
INSERT INTO public."Profile_permissions" VALUES (13, 384);
INSERT INTO public."Profile_permissions" VALUES (1, 385);
INSERT INTO public."Profile_permissions" VALUES (13, 386);
INSERT INTO public."Profile_permissions" VALUES (13, 387);
INSERT INTO public."Profile_permissions" VALUES (13, 388);
INSERT INTO public."Profile_permissions" VALUES (13, 389);
INSERT INTO public."Profile_permissions" VALUES (12, 390);
INSERT INTO public."Profile_permissions" VALUES (13, 392);
INSERT INTO public."Profile_permissions" VALUES (13, 393);
INSERT INTO public."Profile_permissions" VALUES (1, 394);
INSERT INTO public."Profile_permissions" VALUES (8, 395);
INSERT INTO public."Profile_permissions" VALUES (9, 396);
INSERT INTO public."Profile_permissions" VALUES (7, 397);
INSERT INTO public."Profile_permissions" VALUES (13, 411);
INSERT INTO public."Profile_permissions" VALUES (13, 414);
INSERT INTO public."Profile_permissions" VALUES (13, 415);
INSERT INTO public."Profile_permissions" VALUES (13, 416);
INSERT INTO public."Profile_permissions" VALUES (13, 417);
INSERT INTO public."Profile_permissions" VALUES (13, 418);


--
-- TOC entry 3776 (class 0 OID 58314)
-- Dependencies: 231
-- Data for Name: R_ACTIVITE; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3777 (class 0 OID 58319)
-- Dependencies: 232
-- Data for Name: R_BIAT_PROFESSION; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3778 (class 0 OID 58324)
-- Dependencies: 233
-- Data for Name: R_CATEGORY; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3779 (class 0 OID 58329)
-- Dependencies: 234
-- Data for Name: R_CODE_ENG; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3780 (class 0 OID 58336)
-- Dependencies: 235
-- Data for Name: R_CODE_ENG_BCT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3781 (class 0 OID 58341)
-- Dependencies: 236
-- Data for Name: R_CODE_ENG_PERSO_BIAT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3782 (class 0 OID 58346)
-- Dependencies: 237
-- Data for Name: R_INDUSTRY; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3783 (class 0 OID 58351)
-- Dependencies: 238
-- Data for Name: R_LIMITES; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3784 (class 0 OID 58356)
-- Dependencies: 239
-- Data for Name: R_RELATION; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3785 (class 0 OID 58363)
-- Dependencies: 240
-- Data for Name: R_TARGET; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3786 (class 0 OID 58368)
-- Dependencies: 241
-- Data for Name: R_TYPE_CREDIT; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3787 (class 0 OID 58375)
-- Dependencies: 242
-- Data for Name: R_TYPE_ENCOUR; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3788 (class 0 OID 58380)
-- Dependencies: 243
-- Data for Name: R_TYPE_ENG; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3789 (class 0 OID 58387)
-- Dependencies: 244
-- Data for Name: R_TYPE_ENG_MD; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3790 (class 0 OID 58394)
-- Dependencies: 245
-- Data for Name: R_UNITGEST; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3842 (class 0 OID 116832)
-- Dependencies: 297
-- Data for Name: Tree; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Tree" VALUES (3, '11', 'PBD', 'RT1', 'ZT');
INSERT INTO public."Tree" VALUES (4, '12', 'PBD', 'RT1', 'ZT');
INSERT INTO public."Tree" VALUES (5, '13', 'PBD', 'RT2', 'ZA');
INSERT INTO public."Tree" VALUES (1, 'CA', 'PCB', '', 'GGE1');
INSERT INTO public."Tree" VALUES (2, 'CA2', 'PCB', '', 'GGE2');
INSERT INTO public."Tree" VALUES (6, 'CA3', 'PCB', NULL, 'GGE2');


--
-- TOC entry 3832 (class 0 OID 75504)
-- Dependencies: 287
-- Data for Name: Url; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Url" VALUES (1, 'dashboard', '/dashboard');
INSERT INTO public."Url" VALUES (2, 'fonctions', '/base/fonctions');
INSERT INTO public."Url" VALUES (3, 'conception', '/base/database');
INSERT INTO public."Url" VALUES (4, 'tables', '/base/tables');
INSERT INTO public."Url" VALUES (5, 'filtre', '/base/filter');
INSERT INTO public."Url" VALUES (6, 'historique', '/base/historique');
INSERT INTO public."Url" VALUES (16, 'menu', '/base/menu/165');
INSERT INTO public."Url" VALUES (35, 'Compose Message', '/base/composemessage');
INSERT INTO public."Url" VALUES (34, 'Réclamations non traitées', '/base/untreatedReclamations');
INSERT INTO public."Url" VALUES (33, 'Réclamation traitée', '/base/reclamations');
INSERT INTO public."Url" VALUES (36, 'Users', '/base/users');
INSERT INTO public."Url" VALUES (37, 'Profils', '/base/profiles');
INSERT INTO public."Url" VALUES (38, 'Configuration menu', '/base/menuconfiguration');
INSERT INTO public."Url" VALUES (39, 'Ajout menu', '/base/addmenu');
INSERT INTO public."Url" VALUES (40, 'Ajout composant', '/base/addcomponent');
INSERT INTO public."Url" VALUES (41, 'menu', '/base/menu/188');
INSERT INTO public."Url" VALUES (42, 'Inbox', '/base/chat');
INSERT INTO public."Url" VALUES (43, 'Classification', '/base/classification');
INSERT INTO public."Url" VALUES (44, 'Centre de partage', '/base/centerDePartage');
INSERT INTO public."Url" VALUES (45, 'menu', '/base/menu/194');
INSERT INTO public."Url" VALUES (46, 'menu', '/base/menu/195');
INSERT INTO public."Url" VALUES (47, 'menu', '/base/menu/196');


--
-- TOC entry 3844 (class 0 OID 116853)
-- Dependencies: 299
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Users" VALUES (6, 'ZT', 'zoneT@gmail.com', '2023-05-01 21:26:51.841581', '2023-02-25 11:16:10.162739', 'INACTIVE', 'ons', 'kechrid', 'Zone ZT', '$2a$10$uRli0WP86iLxpfveKeor4OnbJaidQz7tleDFRZjFXKb/1r5y3ayC6', 'ZONE', NULL);
INSERT INTO public."Users" VALUES (13, '13', 'agence13@gmail.com', '2023-05-01 21:35:39.083204', '2023-02-27 12:09:31.157222', 'INACTIVE', 'noussa', 'kechrid', 'Agence 13', '$2a$10$nXKkE.gkZt6wPwDPprwh4eRw.ypKdiU86R0IJCO8wFuHQs0i/epY6', 'AGENCE', NULL);
INSERT INTO public."Users" VALUES (14, 'ZA', 'zoneA@gmail.com', '2023-02-28 15:47:03.260585', '2023-02-27 12:09:56.134381', 'INACTIVE', 'ons', 'kechrid', 'Zone Ariana', '$2a$10$GB7V.aPKXUEjTP6I4HNfQ.pl2KOcydW.KfNa9oG2dRW2/PJo6mg1C', 'ZONE', NULL);
INSERT INTO public."Users" VALUES (3, 'RR', 'RR@gmail.com', NULL, '2023-02-10 15:16:20', 'ACTIVE', 'ons', 'kechrid', 'Risque Reporting', '$2a$12$9iT1OfN2t6/X9ecywxJILeEmJ.797GI.RO/UAfIzd5WqliDGXICmS', 'RISQUE REPORTING', 'OK');
INSERT INTO public."Users" VALUES (11, 'RC', 'RC@gmail.com', NULL, '2023-02-27 10:34:23.463808', 'INACTIVE', 'ons', 'kechrid', 'Risque Credit', '$2a$10$uo5OEKn3FpmSwT92zRQLXeQ5aJEhc8gaPQn1qflnWFLKzjBNihJyy', 'RISQUE CREDIT', NULL);
INSERT INTO public."Users" VALUES (16, '14', 'onsagence', NULL, '2023-02-28 15:49:28.62841', 'INACTIVE', 'ons', 'kechrid', 'agence', '$2a$10$uUyOTIRFff1x2SraYHTJxeyJOzXrbPMytWQ1Qh67sDM2gUKtw.e6q', 'AGENCE', NULL);
INSERT INTO public."Users" VALUES (17, NULL, 'aa@aa', NULL, '2023-03-04 12:10:06.655331', 'INACTIVE', 'aa', 'aa', 'aa', '$2a$10$E27nF.2qcaB3ILGfeyYUReizPY0hyNfrOQNBzW9zn4Kd0/eO8bGDi', 'NewUser', NULL);
INSERT INTO public."Users" VALUES (7, 'RT1', 'region@gmail.com', '2023-05-01 16:45:27.201836', '2023-02-25 11:16:17.766821', 'INACTIVE', 'ons', 'kechrid', 'Region RT1', '$2a$10$kLAnLg/BbF7cVyXZQYt1/O2YkHYMJJI7qZbgW/afm22EgKNVt932i', 'REGION', NULL);
INSERT INTO public."Users" VALUES (10, 'GGE1', 'groupe1@gmail.com', '2023-02-27 13:18:08.62797', '2023-02-27 10:18:52.447953', 'INACTIVE', 'ons', 'kechrid', 'Groupe GGE1', '$2a$10$xrM4mHOFm1XYx74oSJ0K8.4Mq9KslDY/B4Emf/SNPEd7J99eZZRAm', 'GROUPE', NULL);
INSERT INTO public."Users" VALUES (5, 'PBD', 'PBD@gmail.com', '2023-05-01 16:45:39.866849', '2023-02-24 14:24:50.327991', 'INACTIVE', 'ons', 'kechrid', 'Pole Banque de Details', '$2a$10$w1V4bZVef6MQbTpmeGIx9OpxQ9PnfF7FAsjuWS0Ckalh2D5960Ega', 'PBD', NULL);
INSERT INTO public."Users" VALUES (4, 'PCB', 'PCB@gmail.com', '2023-05-01 16:46:03.216838', '2023-02-24 14:24:29.076173', 'INACTIVE', 'ons', 'kechrid', 'Pole Corporate Banker', '$2a$10$BMH7T/0hTY5l9sdc31TPROwdnymnpy7i8wVI4HBJFc138Td0pwXyS', 'PCB', NULL);
INSERT INTO public."Users" VALUES (12, '12', 'agence12@gmail.com', '2023-04-27 23:03:13.324919', '2023-02-27 12:09:21.44204', 'INACTIVE', 'ons', 'kechrid', 'Agence 12', '$2a$10$q4Q.w4ERfj//.DuQ/EDoxekG4r5pno6ENZh/y8wt6MH3y4Q5t9Avu', 'AGENCE', NULL);
INSERT INTO public."Users" VALUES (15, 'RT2', 'regionT2@gmail.com', NULL, '2023-02-27 12:10:16.162957', 'INACTIVE', 'ons', 'kechrid', 'Region T2', '$2a$10$pndpnGtTpJ0skg21dH3uSeL1b3xfN.SrnPuU5beI8ZscwfA0Ez1ZO', 'REGION', NULL);
INSERT INTO public."Users" VALUES (9, 'CA', 'charge@gmail.com', NULL, '2023-02-27 10:17:50.375274', 'INACTIVE', 'ons', 'kechrid', 'Chargé d''affaires', '$2a$10$Lk/er4KU0B9waEAFFIFh7earhciltS8ZFnvc7/7lvFMK8j130unOG', 'CHARGE D''AFFAIRES', NULL);
INSERT INTO public."Users" VALUES (1, '11', 'agence11@gmail.com', NULL, '2023-02-10 15:16:20', 'ACTIVE', 'noussa', 'ons', 'Agence 11', '$2a$12$.Vb2qWRFYIh1giU5OaBqkeacSf6XQT4Vbfe4yjOCvvlTRKa.wzeKC', 'AGENCE', 'NO');
INSERT INTO public."Users" VALUES (18, NULL, 'onskechrid1999@gmail.com', NULL, '2023-04-28 09:14:52.210309', 'INACTIVE', 'ons', 'kechrid', 'ons_kechrid', '$2a$10$kPAvMhG8LVdOS4ybnykYWeUAuCUuqjvAfEyC0cKAjnmg/Ec9aj/6C', 'NewUser', NULL);


--
-- TOC entry 3850 (class 0 OID 133224)
-- Dependencies: 305
-- Data for Name: Users_histories; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Users_histories" VALUES (3, 28);
INSERT INTO public."Users_histories" VALUES (3, 29);
INSERT INTO public."Users_histories" VALUES (3, 30);
INSERT INTO public."Users_histories" VALUES (3, 31);
INSERT INTO public."Users_histories" VALUES (3, 32);
INSERT INTO public."Users_histories" VALUES (3, 33);
INSERT INTO public."Users_histories" VALUES (3, 34);
INSERT INTO public."Users_histories" VALUES (3, 35);
INSERT INTO public."Users_histories" VALUES (3, 36);
INSERT INTO public."Users_histories" VALUES (3, 37);
INSERT INTO public."Users_histories" VALUES (3, 38);
INSERT INTO public."Users_histories" VALUES (3, 39);
INSERT INTO public."Users_histories" VALUES (3, 40);
INSERT INTO public."Users_histories" VALUES (3, 41);
INSERT INTO public."Users_histories" VALUES (3, 42);
INSERT INTO public."Users_histories" VALUES (3, 43);
INSERT INTO public."Users_histories" VALUES (3, 44);
INSERT INTO public."Users_histories" VALUES (3, 45);
INSERT INTO public."Users_histories" VALUES (3, 46);
INSERT INTO public."Users_histories" VALUES (3, 47);
INSERT INTO public."Users_histories" VALUES (3, 48);
INSERT INTO public."Users_histories" VALUES (3, 49);
INSERT INTO public."Users_histories" VALUES (3, 50);
INSERT INTO public."Users_histories" VALUES (3, 51);
INSERT INTO public."Users_histories" VALUES (3, 52);
INSERT INTO public."Users_histories" VALUES (3, 53);
INSERT INTO public."Users_histories" VALUES (3, 54);
INSERT INTO public."Users_histories" VALUES (3, 55);
INSERT INTO public."Users_histories" VALUES (3, 56);
INSERT INTO public."Users_histories" VALUES (3, 57);
INSERT INTO public."Users_histories" VALUES (3, 58);
INSERT INTO public."Users_histories" VALUES (3, 59);
INSERT INTO public."Users_histories" VALUES (3, 60);
INSERT INTO public."Users_histories" VALUES (3, 61);
INSERT INTO public."Users_histories" VALUES (3, 62);
INSERT INTO public."Users_histories" VALUES (3, 63);
INSERT INTO public."Users_histories" VALUES (3, 64);
INSERT INTO public."Users_histories" VALUES (3, 65);
INSERT INTO public."Users_histories" VALUES (3, 66);
INSERT INTO public."Users_histories" VALUES (3, 67);
INSERT INTO public."Users_histories" VALUES (3, 68);
INSERT INTO public."Users_histories" VALUES (3, 69);
INSERT INTO public."Users_histories" VALUES (3, 70);
INSERT INTO public."Users_histories" VALUES (3, 71);
INSERT INTO public."Users_histories" VALUES (3, 72);
INSERT INTO public."Users_histories" VALUES (3, 73);
INSERT INTO public."Users_histories" VALUES (3, 74);
INSERT INTO public."Users_histories" VALUES (3, 75);
INSERT INTO public."Users_histories" VALUES (3, 76);
INSERT INTO public."Users_histories" VALUES (3, 77);
INSERT INTO public."Users_histories" VALUES (3, 78);
INSERT INTO public."Users_histories" VALUES (3, 79);
INSERT INTO public."Users_histories" VALUES (3, 80);
INSERT INTO public."Users_histories" VALUES (3, 81);
INSERT INTO public."Users_histories" VALUES (3, 82);
INSERT INTO public."Users_histories" VALUES (3, 83);
INSERT INTO public."Users_histories" VALUES (3, 84);
INSERT INTO public."Users_histories" VALUES (3, 85);
INSERT INTO public."Users_histories" VALUES (3, 86);
INSERT INTO public."Users_histories" VALUES (3, 87);
INSERT INTO public."Users_histories" VALUES (3, 88);
INSERT INTO public."Users_histories" VALUES (3, 89);
INSERT INTO public."Users_histories" VALUES (3, 90);
INSERT INTO public."Users_histories" VALUES (3, 91);
INSERT INTO public."Users_histories" VALUES (3, 93);
INSERT INTO public."Users_histories" VALUES (3, 95);
INSERT INTO public."Users_histories" VALUES (3, 92);
INSERT INTO public."Users_histories" VALUES (3, 94);
INSERT INTO public."Users_histories" VALUES (3, 96);
INSERT INTO public."Users_histories" VALUES (3, 97);
INSERT INTO public."Users_histories" VALUES (3, 98);
INSERT INTO public."Users_histories" VALUES (3, 99);
INSERT INTO public."Users_histories" VALUES (3, 100);
INSERT INTO public."Users_histories" VALUES (3, 101);
INSERT INTO public."Users_histories" VALUES (3, 102);
INSERT INTO public."Users_histories" VALUES (3, 103);
INSERT INTO public."Users_histories" VALUES (3, 104);
INSERT INTO public."Users_histories" VALUES (3, 105);
INSERT INTO public."Users_histories" VALUES (3, 106);
INSERT INTO public."Users_histories" VALUES (3, 107);
INSERT INTO public."Users_histories" VALUES (3, 108);
INSERT INTO public."Users_histories" VALUES (3, 109);
INSERT INTO public."Users_histories" VALUES (3, 110);
INSERT INTO public."Users_histories" VALUES (3, 111);
INSERT INTO public."Users_histories" VALUES (3, 112);
INSERT INTO public."Users_histories" VALUES (3, 113);
INSERT INTO public."Users_histories" VALUES (3, 114);
INSERT INTO public."Users_histories" VALUES (3, 115);
INSERT INTO public."Users_histories" VALUES (3, 116);
INSERT INTO public."Users_histories" VALUES (3, 117);
INSERT INTO public."Users_histories" VALUES (3, 118);
INSERT INTO public."Users_histories" VALUES (3, 119);
INSERT INTO public."Users_histories" VALUES (3, 120);
INSERT INTO public."Users_histories" VALUES (3, 121);
INSERT INTO public."Users_histories" VALUES (3, 122);
INSERT INTO public."Users_histories" VALUES (3, 123);
INSERT INTO public."Users_histories" VALUES (3, 124);
INSERT INTO public."Users_histories" VALUES (3, 125);
INSERT INTO public."Users_histories" VALUES (1, 126);
INSERT INTO public."Users_histories" VALUES (3, 127);
INSERT INTO public."Users_histories" VALUES (1, 128);
INSERT INTO public."Users_histories" VALUES (1, 129);
INSERT INTO public."Users_histories" VALUES (1, 130);
INSERT INTO public."Users_histories" VALUES (1, 131);
INSERT INTO public."Users_histories" VALUES (1, 132);
INSERT INTO public."Users_histories" VALUES (1, 133);
INSERT INTO public."Users_histories" VALUES (1, 134);
INSERT INTO public."Users_histories" VALUES (1, 135);
INSERT INTO public."Users_histories" VALUES (1, 136);
INSERT INTO public."Users_histories" VALUES (1, 137);
INSERT INTO public."Users_histories" VALUES (1, 138);
INSERT INTO public."Users_histories" VALUES (1, 139);
INSERT INTO public."Users_histories" VALUES (3, 140);
INSERT INTO public."Users_histories" VALUES (3, 141);
INSERT INTO public."Users_histories" VALUES (1, 142);
INSERT INTO public."Users_histories" VALUES (1, 143);
INSERT INTO public."Users_histories" VALUES (1, 144);
INSERT INTO public."Users_histories" VALUES (1, 145);
INSERT INTO public."Users_histories" VALUES (1, 146);
INSERT INTO public."Users_histories" VALUES (3, 147);
INSERT INTO public."Users_histories" VALUES (3, 148);
INSERT INTO public."Users_histories" VALUES (3, 149);
INSERT INTO public."Users_histories" VALUES (3, 150);
INSERT INTO public."Users_histories" VALUES (1, 151);
INSERT INTO public."Users_histories" VALUES (1, 153);
INSERT INTO public."Users_histories" VALUES (1, 152);
INSERT INTO public."Users_histories" VALUES (1, 154);
INSERT INTO public."Users_histories" VALUES (3, 155);
INSERT INTO public."Users_histories" VALUES (3, 156);
INSERT INTO public."Users_histories" VALUES (1, 157);
INSERT INTO public."Users_histories" VALUES (1, 158);
INSERT INTO public."Users_histories" VALUES (3, 159);
INSERT INTO public."Users_histories" VALUES (3, 160);
INSERT INTO public."Users_histories" VALUES (3, 161);
INSERT INTO public."Users_histories" VALUES (3, 162);
INSERT INTO public."Users_histories" VALUES (1, 163);
INSERT INTO public."Users_histories" VALUES (1, 164);
INSERT INTO public."Users_histories" VALUES (3, 165);
INSERT INTO public."Users_histories" VALUES (1, 166);
INSERT INTO public."Users_histories" VALUES (1, 167);
INSERT INTO public."Users_histories" VALUES (3, 168);
INSERT INTO public."Users_histories" VALUES (1, 169);
INSERT INTO public."Users_histories" VALUES (1, 170);
INSERT INTO public."Users_histories" VALUES (3, 171);
INSERT INTO public."Users_histories" VALUES (1, 172);
INSERT INTO public."Users_histories" VALUES (1, 173);
INSERT INTO public."Users_histories" VALUES (3, 174);
INSERT INTO public."Users_histories" VALUES (1, 175);
INSERT INTO public."Users_histories" VALUES (1, 176);
INSERT INTO public."Users_histories" VALUES (3, 177);
INSERT INTO public."Users_histories" VALUES (3, 178);
INSERT INTO public."Users_histories" VALUES (1, 179);
INSERT INTO public."Users_histories" VALUES (1, 180);
INSERT INTO public."Users_histories" VALUES (3, 181);
INSERT INTO public."Users_histories" VALUES (1, 182);
INSERT INTO public."Users_histories" VALUES (1, 183);
INSERT INTO public."Users_histories" VALUES (3, 184);
INSERT INTO public."Users_histories" VALUES (3, 185);
INSERT INTO public."Users_histories" VALUES (1, 186);
INSERT INTO public."Users_histories" VALUES (1, 187);
INSERT INTO public."Users_histories" VALUES (3, 188);
INSERT INTO public."Users_histories" VALUES (3, 189);
INSERT INTO public."Users_histories" VALUES (1, 190);
INSERT INTO public."Users_histories" VALUES (1, 191);
INSERT INTO public."Users_histories" VALUES (3, 192);
INSERT INTO public."Users_histories" VALUES (1, 193);
INSERT INTO public."Users_histories" VALUES (1, 194);
INSERT INTO public."Users_histories" VALUES (3, 195);
INSERT INTO public."Users_histories" VALUES (1, 196);
INSERT INTO public."Users_histories" VALUES (3, 197);
INSERT INTO public."Users_histories" VALUES (1, 198);
INSERT INTO public."Users_histories" VALUES (1, 199);
INSERT INTO public."Users_histories" VALUES (3, 200);
INSERT INTO public."Users_histories" VALUES (1, 201);
INSERT INTO public."Users_histories" VALUES (1, 202);
INSERT INTO public."Users_histories" VALUES (1, 203);
INSERT INTO public."Users_histories" VALUES (3, 204);
INSERT INTO public."Users_histories" VALUES (1, 205);
INSERT INTO public."Users_histories" VALUES (1, 206);
INSERT INTO public."Users_histories" VALUES (1, 207);
INSERT INTO public."Users_histories" VALUES (1, 208);
INSERT INTO public."Users_histories" VALUES (1, 209);
INSERT INTO public."Users_histories" VALUES (3, 210);
INSERT INTO public."Users_histories" VALUES (3, 211);
INSERT INTO public."Users_histories" VALUES (3, 212);
INSERT INTO public."Users_histories" VALUES (3, 213);
INSERT INTO public."Users_histories" VALUES (3, 214);
INSERT INTO public."Users_histories" VALUES (3, 215);
INSERT INTO public."Users_histories" VALUES (3, 216);
INSERT INTO public."Users_histories" VALUES (3, 217);
INSERT INTO public."Users_histories" VALUES (3, 218);
INSERT INTO public."Users_histories" VALUES (3, 219);
INSERT INTO public."Users_histories" VALUES (3, 220);
INSERT INTO public."Users_histories" VALUES (3, 221);
INSERT INTO public."Users_histories" VALUES (3, 222);
INSERT INTO public."Users_histories" VALUES (3, 223);
INSERT INTO public."Users_histories" VALUES (3, 224);
INSERT INTO public."Users_histories" VALUES (3, 225);
INSERT INTO public."Users_histories" VALUES (3, 226);
INSERT INTO public."Users_histories" VALUES (3, 227);
INSERT INTO public."Users_histories" VALUES (3, 228);
INSERT INTO public."Users_histories" VALUES (3, 229);
INSERT INTO public."Users_histories" VALUES (3, 230);
INSERT INTO public."Users_histories" VALUES (3, 231);
INSERT INTO public."Users_histories" VALUES (3, 232);
INSERT INTO public."Users_histories" VALUES (3, 233);
INSERT INTO public."Users_histories" VALUES (3, 234);
INSERT INTO public."Users_histories" VALUES (3, 235);
INSERT INTO public."Users_histories" VALUES (3, 236);
INSERT INTO public."Users_histories" VALUES (3, 237);
INSERT INTO public."Users_histories" VALUES (3, 238);
INSERT INTO public."Users_histories" VALUES (3, 239);
INSERT INTO public."Users_histories" VALUES (3, 240);
INSERT INTO public."Users_histories" VALUES (3, 241);
INSERT INTO public."Users_histories" VALUES (3, 242);
INSERT INTO public."Users_histories" VALUES (3, 243);
INSERT INTO public."Users_histories" VALUES (3, 244);
INSERT INTO public."Users_histories" VALUES (3, 245);
INSERT INTO public."Users_histories" VALUES (3, 246);
INSERT INTO public."Users_histories" VALUES (3, 247);
INSERT INTO public."Users_histories" VALUES (3, 248);
INSERT INTO public."Users_histories" VALUES (3, 249);
INSERT INTO public."Users_histories" VALUES (1, 250);
INSERT INTO public."Users_histories" VALUES (1, 251);
INSERT INTO public."Users_histories" VALUES (1, 252);
INSERT INTO public."Users_histories" VALUES (1, 253);
INSERT INTO public."Users_histories" VALUES (3, 254);
INSERT INTO public."Users_histories" VALUES (3, 255);
INSERT INTO public."Users_histories" VALUES (3, 256);
INSERT INTO public."Users_histories" VALUES (3, 257);
INSERT INTO public."Users_histories" VALUES (3, 258);
INSERT INTO public."Users_histories" VALUES (3, 259);
INSERT INTO public."Users_histories" VALUES (3, 260);
INSERT INTO public."Users_histories" VALUES (3, 261);
INSERT INTO public."Users_histories" VALUES (3, 262);
INSERT INTO public."Users_histories" VALUES (3, 263);
INSERT INTO public."Users_histories" VALUES (3, 264);
INSERT INTO public."Users_histories" VALUES (3, 265);
INSERT INTO public."Users_histories" VALUES (3, 266);
INSERT INTO public."Users_histories" VALUES (3, 267);
INSERT INTO public."Users_histories" VALUES (3, 269);
INSERT INTO public."Users_histories" VALUES (3, 268);
INSERT INTO public."Users_histories" VALUES (3, 270);
INSERT INTO public."Users_histories" VALUES (3, 271);
INSERT INTO public."Users_histories" VALUES (3, 272);
INSERT INTO public."Users_histories" VALUES (3, 273);
INSERT INTO public."Users_histories" VALUES (1, 274);
INSERT INTO public."Users_histories" VALUES (1, 275);
INSERT INTO public."Users_histories" VALUES (1, 276);
INSERT INTO public."Users_histories" VALUES (1, 277);
INSERT INTO public."Users_histories" VALUES (1, 278);
INSERT INTO public."Users_histories" VALUES (1, 279);
INSERT INTO public."Users_histories" VALUES (1, 280);
INSERT INTO public."Users_histories" VALUES (1, 281);
INSERT INTO public."Users_histories" VALUES (1, 282);
INSERT INTO public."Users_histories" VALUES (1, 283);
INSERT INTO public."Users_histories" VALUES (1, 284);
INSERT INTO public."Users_histories" VALUES (3, 285);
INSERT INTO public."Users_histories" VALUES (3, 286);
INSERT INTO public."Users_histories" VALUES (3, 287);
INSERT INTO public."Users_histories" VALUES (3, 288);
INSERT INTO public."Users_histories" VALUES (1, 289);
INSERT INTO public."Users_histories" VALUES (1, 290);
INSERT INTO public."Users_histories" VALUES (1, 291);
INSERT INTO public."Users_histories" VALUES (1, 292);
INSERT INTO public."Users_histories" VALUES (1, 293);
INSERT INTO public."Users_histories" VALUES (1, 294);
INSERT INTO public."Users_histories" VALUES (1, 295);
INSERT INTO public."Users_histories" VALUES (1, 296);
INSERT INTO public."Users_histories" VALUES (1, 297);
INSERT INTO public."Users_histories" VALUES (1, 298);
INSERT INTO public."Users_histories" VALUES (1, 299);
INSERT INTO public."Users_histories" VALUES (1, 301);
INSERT INTO public."Users_histories" VALUES (1, 300);
INSERT INTO public."Users_histories" VALUES (3, 302);
INSERT INTO public."Users_histories" VALUES (3, 303);
INSERT INTO public."Users_histories" VALUES (3, 304);
INSERT INTO public."Users_histories" VALUES (1, 305);
INSERT INTO public."Users_histories" VALUES (3, 306);
INSERT INTO public."Users_histories" VALUES (1, 307);
INSERT INTO public."Users_histories" VALUES (1, 308);
INSERT INTO public."Users_histories" VALUES (1, 309);
INSERT INTO public."Users_histories" VALUES (3, 310);
INSERT INTO public."Users_histories" VALUES (1, 311);
INSERT INTO public."Users_histories" VALUES (1, 312);
INSERT INTO public."Users_histories" VALUES (1, 313);
INSERT INTO public."Users_histories" VALUES (1, 314);
INSERT INTO public."Users_histories" VALUES (1, 316);
INSERT INTO public."Users_histories" VALUES (1, 315);
INSERT INTO public."Users_histories" VALUES (3, 317);
INSERT INTO public."Users_histories" VALUES (1, 318);
INSERT INTO public."Users_histories" VALUES (1, 319);
INSERT INTO public."Users_histories" VALUES (1, 320);
INSERT INTO public."Users_histories" VALUES (1, 321);
INSERT INTO public."Users_histories" VALUES (1, 322);
INSERT INTO public."Users_histories" VALUES (1, 323);
INSERT INTO public."Users_histories" VALUES (1, 324);
INSERT INTO public."Users_histories" VALUES (1, 325);
INSERT INTO public."Users_histories" VALUES (1, 326);
INSERT INTO public."Users_histories" VALUES (1, 327);
INSERT INTO public."Users_histories" VALUES (1, 328);
INSERT INTO public."Users_histories" VALUES (1, 329);
INSERT INTO public."Users_histories" VALUES (1, 330);
INSERT INTO public."Users_histories" VALUES (1, 331);
INSERT INTO public."Users_histories" VALUES (1, 332);
INSERT INTO public."Users_histories" VALUES (1, 335);
INSERT INTO public."Users_histories" VALUES (1, 333);
INSERT INTO public."Users_histories" VALUES (1, 334);
INSERT INTO public."Users_histories" VALUES (1, 336);
INSERT INTO public."Users_histories" VALUES (1, 340);
INSERT INTO public."Users_histories" VALUES (1, 337);
INSERT INTO public."Users_histories" VALUES (1, 339);
INSERT INTO public."Users_histories" VALUES (1, 338);
INSERT INTO public."Users_histories" VALUES (1, 341);
INSERT INTO public."Users_histories" VALUES (1, 342);
INSERT INTO public."Users_histories" VALUES (1, 343);
INSERT INTO public."Users_histories" VALUES (1, 344);
INSERT INTO public."Users_histories" VALUES (1, 345);
INSERT INTO public."Users_histories" VALUES (1, 346);
INSERT INTO public."Users_histories" VALUES (1, 347);
INSERT INTO public."Users_histories" VALUES (1, 350);
INSERT INTO public."Users_histories" VALUES (1, 348);
INSERT INTO public."Users_histories" VALUES (1, 349);
INSERT INTO public."Users_histories" VALUES (3, 351);
INSERT INTO public."Users_histories" VALUES (3, 352);
INSERT INTO public."Users_histories" VALUES (3, 353);
INSERT INTO public."Users_histories" VALUES (3, 354);
INSERT INTO public."Users_histories" VALUES (3, 355);
INSERT INTO public."Users_histories" VALUES (1, 356);
INSERT INTO public."Users_histories" VALUES (1, 357);
INSERT INTO public."Users_histories" VALUES (3, 358);
INSERT INTO public."Users_histories" VALUES (3, 359);
INSERT INTO public."Users_histories" VALUES (1, 360);
INSERT INTO public."Users_histories" VALUES (1, 361);
INSERT INTO public."Users_histories" VALUES (3, 362);
INSERT INTO public."Users_histories" VALUES (3, 363);
INSERT INTO public."Users_histories" VALUES (3, 364);
INSERT INTO public."Users_histories" VALUES (3, 365);
INSERT INTO public."Users_histories" VALUES (3, 366);
INSERT INTO public."Users_histories" VALUES (1, 367);
INSERT INTO public."Users_histories" VALUES (1, 368);
INSERT INTO public."Users_histories" VALUES (1, 369);
INSERT INTO public."Users_histories" VALUES (1, 370);
INSERT INTO public."Users_histories" VALUES (3, 371);
INSERT INTO public."Users_histories" VALUES (3, 372);
INSERT INTO public."Users_histories" VALUES (3, 373);
INSERT INTO public."Users_histories" VALUES (3, 374);
INSERT INTO public."Users_histories" VALUES (3, 375);
INSERT INTO public."Users_histories" VALUES (3, 376);
INSERT INTO public."Users_histories" VALUES (3, 377);
INSERT INTO public."Users_histories" VALUES (3, 378);
INSERT INTO public."Users_histories" VALUES (3, 379);
INSERT INTO public."Users_histories" VALUES (3, 380);
INSERT INTO public."Users_histories" VALUES (3, 381);
INSERT INTO public."Users_histories" VALUES (3, 382);
INSERT INTO public."Users_histories" VALUES (3, 383);
INSERT INTO public."Users_histories" VALUES (3, 384);
INSERT INTO public."Users_histories" VALUES (3, 385);
INSERT INTO public."Users_histories" VALUES (1, 386);
INSERT INTO public."Users_histories" VALUES (3, 387);
INSERT INTO public."Users_histories" VALUES (3, 388);
INSERT INTO public."Users_histories" VALUES (3, 389);
INSERT INTO public."Users_histories" VALUES (3, 390);
INSERT INTO public."Users_histories" VALUES (3, 391);
INSERT INTO public."Users_histories" VALUES (3, 392);
INSERT INTO public."Users_histories" VALUES (3, 393);
INSERT INTO public."Users_histories" VALUES (3, 394);
INSERT INTO public."Users_histories" VALUES (3, 395);
INSERT INTO public."Users_histories" VALUES (3, 396);
INSERT INTO public."Users_histories" VALUES (3, 397);
INSERT INTO public."Users_histories" VALUES (3, 398);
INSERT INTO public."Users_histories" VALUES (3, 399);
INSERT INTO public."Users_histories" VALUES (3, 400);
INSERT INTO public."Users_histories" VALUES (3, 401);
INSERT INTO public."Users_histories" VALUES (1, 402);
INSERT INTO public."Users_histories" VALUES (1, 403);
INSERT INTO public."Users_histories" VALUES (1, 404);
INSERT INTO public."Users_histories" VALUES (1, 405);
INSERT INTO public."Users_histories" VALUES (1, 406);
INSERT INTO public."Users_histories" VALUES (1, 407);
INSERT INTO public."Users_histories" VALUES (1, 408);
INSERT INTO public."Users_histories" VALUES (1, 409);
INSERT INTO public."Users_histories" VALUES (1, 410);
INSERT INTO public."Users_histories" VALUES (1, 411);
INSERT INTO public."Users_histories" VALUES (1, 412);
INSERT INTO public."Users_histories" VALUES (1, 413);
INSERT INTO public."Users_histories" VALUES (1, 414);
INSERT INTO public."Users_histories" VALUES (1, 415);
INSERT INTO public."Users_histories" VALUES (1, 416);
INSERT INTO public."Users_histories" VALUES (1, 417);
INSERT INTO public."Users_histories" VALUES (1, 418);
INSERT INTO public."Users_histories" VALUES (1, 419);
INSERT INTO public."Users_histories" VALUES (1, 420);
INSERT INTO public."Users_histories" VALUES (1, 421);
INSERT INTO public."Users_histories" VALUES (1, 422);
INSERT INTO public."Users_histories" VALUES (1, 423);
INSERT INTO public."Users_histories" VALUES (1, 424);
INSERT INTO public."Users_histories" VALUES (1, 425);
INSERT INTO public."Users_histories" VALUES (1, 426);
INSERT INTO public."Users_histories" VALUES (1, 427);
INSERT INTO public."Users_histories" VALUES (1, 428);
INSERT INTO public."Users_histories" VALUES (1, 429);
INSERT INTO public."Users_histories" VALUES (1, 430);
INSERT INTO public."Users_histories" VALUES (1, 431);
INSERT INTO public."Users_histories" VALUES (1, 432);
INSERT INTO public."Users_histories" VALUES (1, 433);
INSERT INTO public."Users_histories" VALUES (1, 434);
INSERT INTO public."Users_histories" VALUES (1, 435);
INSERT INTO public."Users_histories" VALUES (1, 436);
INSERT INTO public."Users_histories" VALUES (1, 437);
INSERT INTO public."Users_histories" VALUES (1, 438);
INSERT INTO public."Users_histories" VALUES (1, 439);
INSERT INTO public."Users_histories" VALUES (1, 440);
INSERT INTO public."Users_histories" VALUES (1, 441);
INSERT INTO public."Users_histories" VALUES (1, 442);
INSERT INTO public."Users_histories" VALUES (1, 443);
INSERT INTO public."Users_histories" VALUES (1, 444);
INSERT INTO public."Users_histories" VALUES (1, 445);
INSERT INTO public."Users_histories" VALUES (1, 446);
INSERT INTO public."Users_histories" VALUES (3, 447);
INSERT INTO public."Users_histories" VALUES (3, 448);
INSERT INTO public."Users_histories" VALUES (3, 449);
INSERT INTO public."Users_histories" VALUES (3, 450);
INSERT INTO public."Users_histories" VALUES (1, 451);
INSERT INTO public."Users_histories" VALUES (3, 452);
INSERT INTO public."Users_histories" VALUES (3, 453);
INSERT INTO public."Users_histories" VALUES (3, 454);
INSERT INTO public."Users_histories" VALUES (3, 455);
INSERT INTO public."Users_histories" VALUES (3, 456);
INSERT INTO public."Users_histories" VALUES (3, 457);
INSERT INTO public."Users_histories" VALUES (1, 458);
INSERT INTO public."Users_histories" VALUES (12, 459);
INSERT INTO public."Users_histories" VALUES (12, 460);
INSERT INTO public."Users_histories" VALUES (1, 461);
INSERT INTO public."Users_histories" VALUES (1, 462);
INSERT INTO public."Users_histories" VALUES (1, 463);
INSERT INTO public."Users_histories" VALUES (1, 464);
INSERT INTO public."Users_histories" VALUES (1, 465);
INSERT INTO public."Users_histories" VALUES (1, 466);
INSERT INTO public."Users_histories" VALUES (1, 468);
INSERT INTO public."Users_histories" VALUES (1, 467);
INSERT INTO public."Users_histories" VALUES (1, 469);
INSERT INTO public."Users_histories" VALUES (1, 470);
INSERT INTO public."Users_histories" VALUES (3, 471);
INSERT INTO public."Users_histories" VALUES (3, 472);
INSERT INTO public."Users_histories" VALUES (3, 473);
INSERT INTO public."Users_histories" VALUES (3, 474);
INSERT INTO public."Users_histories" VALUES (3, 475);
INSERT INTO public."Users_histories" VALUES (3, 476);
INSERT INTO public."Users_histories" VALUES (3, 477);
INSERT INTO public."Users_histories" VALUES (3, 478);
INSERT INTO public."Users_histories" VALUES (3, 479);
INSERT INTO public."Users_histories" VALUES (3, 480);
INSERT INTO public."Users_histories" VALUES (3, 481);
INSERT INTO public."Users_histories" VALUES (3, 482);
INSERT INTO public."Users_histories" VALUES (3, 483);
INSERT INTO public."Users_histories" VALUES (3, 484);
INSERT INTO public."Users_histories" VALUES (3, 485);
INSERT INTO public."Users_histories" VALUES (3, 486);
INSERT INTO public."Users_histories" VALUES (3, 487);
INSERT INTO public."Users_histories" VALUES (3, 488);
INSERT INTO public."Users_histories" VALUES (3, 489);
INSERT INTO public."Users_histories" VALUES (3, 490);
INSERT INTO public."Users_histories" VALUES (3, 491);
INSERT INTO public."Users_histories" VALUES (3, 492);
INSERT INTO public."Users_histories" VALUES (3, 493);
INSERT INTO public."Users_histories" VALUES (3, 494);
INSERT INTO public."Users_histories" VALUES (3, 495);
INSERT INTO public."Users_histories" VALUES (3, 496);
INSERT INTO public."Users_histories" VALUES (3, 497);
INSERT INTO public."Users_histories" VALUES (3, 498);
INSERT INTO public."Users_histories" VALUES (3, 499);
INSERT INTO public."Users_histories" VALUES (3, 500);
INSERT INTO public."Users_histories" VALUES (3, 501);
INSERT INTO public."Users_histories" VALUES (3, 502);
INSERT INTO public."Users_histories" VALUES (3, 503);
INSERT INTO public."Users_histories" VALUES (3, 504);
INSERT INTO public."Users_histories" VALUES (3, 505);
INSERT INTO public."Users_histories" VALUES (3, 506);
INSERT INTO public."Users_histories" VALUES (3, 507);
INSERT INTO public."Users_histories" VALUES (3, 508);
INSERT INTO public."Users_histories" VALUES (3, 509);
INSERT INTO public."Users_histories" VALUES (3, 510);
INSERT INTO public."Users_histories" VALUES (3, 511);
INSERT INTO public."Users_histories" VALUES (3, 512);
INSERT INTO public."Users_histories" VALUES (3, 513);
INSERT INTO public."Users_histories" VALUES (3, 514);
INSERT INTO public."Users_histories" VALUES (3, 515);
INSERT INTO public."Users_histories" VALUES (3, 516);
INSERT INTO public."Users_histories" VALUES (3, 517);
INSERT INTO public."Users_histories" VALUES (3, 518);
INSERT INTO public."Users_histories" VALUES (3, 519);
INSERT INTO public."Users_histories" VALUES (3, 520);
INSERT INTO public."Users_histories" VALUES (3, 521);
INSERT INTO public."Users_histories" VALUES (3, 522);
INSERT INTO public."Users_histories" VALUES (3, 523);
INSERT INTO public."Users_histories" VALUES (3, 524);
INSERT INTO public."Users_histories" VALUES (3, 525);
INSERT INTO public."Users_histories" VALUES (3, 526);
INSERT INTO public."Users_histories" VALUES (3, 528);
INSERT INTO public."Users_histories" VALUES (3, 527);
INSERT INTO public."Users_histories" VALUES (3, 529);
INSERT INTO public."Users_histories" VALUES (3, 530);
INSERT INTO public."Users_histories" VALUES (3, 531);
INSERT INTO public."Users_histories" VALUES (3, 532);
INSERT INTO public."Users_histories" VALUES (3, 533);
INSERT INTO public."Users_histories" VALUES (3, 534);
INSERT INTO public."Users_histories" VALUES (3, 535);
INSERT INTO public."Users_histories" VALUES (3, 536);
INSERT INTO public."Users_histories" VALUES (3, 537);
INSERT INTO public."Users_histories" VALUES (3, 538);
INSERT INTO public."Users_histories" VALUES (3, 539);
INSERT INTO public."Users_histories" VALUES (3, 540);
INSERT INTO public."Users_histories" VALUES (3, 541);
INSERT INTO public."Users_histories" VALUES (1, 542);
INSERT INTO public."Users_histories" VALUES (1, 543);
INSERT INTO public."Users_histories" VALUES (1, 544);
INSERT INTO public."Users_histories" VALUES (3, 545);
INSERT INTO public."Users_histories" VALUES (3, 546);
INSERT INTO public."Users_histories" VALUES (1, 547);
INSERT INTO public."Users_histories" VALUES (1, 548);
INSERT INTO public."Users_histories" VALUES (3, 549);
INSERT INTO public."Users_histories" VALUES (3, 550);
INSERT INTO public."Users_histories" VALUES (3, 551);
INSERT INTO public."Users_histories" VALUES (3, 552);
INSERT INTO public."Users_histories" VALUES (3, 553);
INSERT INTO public."Users_histories" VALUES (3, 554);
INSERT INTO public."Users_histories" VALUES (1, 555);
INSERT INTO public."Users_histories" VALUES (1, 556);
INSERT INTO public."Users_histories" VALUES (3, 557);
INSERT INTO public."Users_histories" VALUES (3, 558);
INSERT INTO public."Users_histories" VALUES (3, 559);
INSERT INTO public."Users_histories" VALUES (3, 560);
INSERT INTO public."Users_histories" VALUES (3, 561);
INSERT INTO public."Users_histories" VALUES (3, 562);
INSERT INTO public."Users_histories" VALUES (3, 563);
INSERT INTO public."Users_histories" VALUES (3, 564);
INSERT INTO public."Users_histories" VALUES (3, 565);
INSERT INTO public."Users_histories" VALUES (3, 566);
INSERT INTO public."Users_histories" VALUES (3, 567);
INSERT INTO public."Users_histories" VALUES (3, 568);
INSERT INTO public."Users_histories" VALUES (3, 569);
INSERT INTO public."Users_histories" VALUES (3, 570);
INSERT INTO public."Users_histories" VALUES (3, 571);
INSERT INTO public."Users_histories" VALUES (3, 572);
INSERT INTO public."Users_histories" VALUES (1, 573);
INSERT INTO public."Users_histories" VALUES (1, 574);
INSERT INTO public."Users_histories" VALUES (1, 575);
INSERT INTO public."Users_histories" VALUES (1, 576);
INSERT INTO public."Users_histories" VALUES (3, 577);
INSERT INTO public."Users_histories" VALUES (3, 578);
INSERT INTO public."Users_histories" VALUES (3, 579);
INSERT INTO public."Users_histories" VALUES (1, 580);
INSERT INTO public."Users_histories" VALUES (3, 581);
INSERT INTO public."Users_histories" VALUES (1, 582);
INSERT INTO public."Users_histories" VALUES (3, 583);
INSERT INTO public."Users_histories" VALUES (1, 584);
INSERT INTO public."Users_histories" VALUES (1, 585);
INSERT INTO public."Users_histories" VALUES (1, 586);
INSERT INTO public."Users_histories" VALUES (1, 587);
INSERT INTO public."Users_histories" VALUES (1, 588);
INSERT INTO public."Users_histories" VALUES (3, 589);
INSERT INTO public."Users_histories" VALUES (1, 590);
INSERT INTO public."Users_histories" VALUES (1, 591);
INSERT INTO public."Users_histories" VALUES (1, 592);
INSERT INTO public."Users_histories" VALUES (1, 593);
INSERT INTO public."Users_histories" VALUES (1, 594);
INSERT INTO public."Users_histories" VALUES (3, 595);
INSERT INTO public."Users_histories" VALUES (3, 596);
INSERT INTO public."Users_histories" VALUES (1, 597);
INSERT INTO public."Users_histories" VALUES (1, 598);
INSERT INTO public."Users_histories" VALUES (3, 599);
INSERT INTO public."Users_histories" VALUES (3, 600);
INSERT INTO public."Users_histories" VALUES (1, 601);
INSERT INTO public."Users_histories" VALUES (1, 602);
INSERT INTO public."Users_histories" VALUES (3, 603);
INSERT INTO public."Users_histories" VALUES (3, 604);
INSERT INTO public."Users_histories" VALUES (3, 605);
INSERT INTO public."Users_histories" VALUES (3, 606);
INSERT INTO public."Users_histories" VALUES (3, 607);
INSERT INTO public."Users_histories" VALUES (3, 608);
INSERT INTO public."Users_histories" VALUES (3, 609);
INSERT INTO public."Users_histories" VALUES (3, 610);
INSERT INTO public."Users_histories" VALUES (3, 611);
INSERT INTO public."Users_histories" VALUES (3, 612);
INSERT INTO public."Users_histories" VALUES (3, 613);
INSERT INTO public."Users_histories" VALUES (3, 614);
INSERT INTO public."Users_histories" VALUES (3, 615);
INSERT INTO public."Users_histories" VALUES (3, 616);
INSERT INTO public."Users_histories" VALUES (3, 617);
INSERT INTO public."Users_histories" VALUES (3, 618);
INSERT INTO public."Users_histories" VALUES (3, 619);
INSERT INTO public."Users_histories" VALUES (3, 620);
INSERT INTO public."Users_histories" VALUES (3, 621);
INSERT INTO public."Users_histories" VALUES (3, 622);
INSERT INTO public."Users_histories" VALUES (3, 623);
INSERT INTO public."Users_histories" VALUES (3, 624);
INSERT INTO public."Users_histories" VALUES (3, 625);
INSERT INTO public."Users_histories" VALUES (3, 626);
INSERT INTO public."Users_histories" VALUES (3, 627);
INSERT INTO public."Users_histories" VALUES (3, 628);
INSERT INTO public."Users_histories" VALUES (3, 629);
INSERT INTO public."Users_histories" VALUES (3, 630);
INSERT INTO public."Users_histories" VALUES (3, 631);
INSERT INTO public."Users_histories" VALUES (3, 632);
INSERT INTO public."Users_histories" VALUES (3, 633);
INSERT INTO public."Users_histories" VALUES (3, 634);
INSERT INTO public."Users_histories" VALUES (3, 635);
INSERT INTO public."Users_histories" VALUES (13, 636);
INSERT INTO public."Users_histories" VALUES (13, 637);
INSERT INTO public."Users_histories" VALUES (13, 638);
INSERT INTO public."Users_histories" VALUES (13, 639);
INSERT INTO public."Users_histories" VALUES (3, 640);
INSERT INTO public."Users_histories" VALUES (3, 641);
INSERT INTO public."Users_histories" VALUES (3, 642);
INSERT INTO public."Users_histories" VALUES (3, 643);
INSERT INTO public."Users_histories" VALUES (3, 644);
INSERT INTO public."Users_histories" VALUES (3, 645);
INSERT INTO public."Users_histories" VALUES (3, 646);
INSERT INTO public."Users_histories" VALUES (3, 647);
INSERT INTO public."Users_histories" VALUES (3, 650);
INSERT INTO public."Users_histories" VALUES (3, 651);
INSERT INTO public."Users_histories" VALUES (3, 648);
INSERT INTO public."Users_histories" VALUES (3, 649);
INSERT INTO public."Users_histories" VALUES (3, 652);
INSERT INTO public."Users_histories" VALUES (3, 653);
INSERT INTO public."Users_histories" VALUES (3, 654);
INSERT INTO public."Users_histories" VALUES (3, 655);
INSERT INTO public."Users_histories" VALUES (3, 656);
INSERT INTO public."Users_histories" VALUES (3, 657);
INSERT INTO public."Users_histories" VALUES (3, 658);
INSERT INTO public."Users_histories" VALUES (3, 659);
INSERT INTO public."Users_histories" VALUES (3, 660);
INSERT INTO public."Users_histories" VALUES (3, 661);
INSERT INTO public."Users_histories" VALUES (3, 662);
INSERT INTO public."Users_histories" VALUES (3, 663);
INSERT INTO public."Users_histories" VALUES (3, 664);
INSERT INTO public."Users_histories" VALUES (3, 665);
INSERT INTO public."Users_histories" VALUES (3, 666);
INSERT INTO public."Users_histories" VALUES (3, 668);
INSERT INTO public."Users_histories" VALUES (3, 667);
INSERT INTO public."Users_histories" VALUES (3, 669);
INSERT INTO public."Users_histories" VALUES (3, 670);
INSERT INTO public."Users_histories" VALUES (3, 671);
INSERT INTO public."Users_histories" VALUES (3, 672);
INSERT INTO public."Users_histories" VALUES (3, 673);
INSERT INTO public."Users_histories" VALUES (3, 674);
INSERT INTO public."Users_histories" VALUES (3, 675);
INSERT INTO public."Users_histories" VALUES (13, 676);
INSERT INTO public."Users_histories" VALUES (3, 677);
INSERT INTO public."Users_histories" VALUES (3, 678);
INSERT INTO public."Users_histories" VALUES (3, 679);
INSERT INTO public."Users_histories" VALUES (3, 680);
INSERT INTO public."Users_histories" VALUES (3, 681);
INSERT INTO public."Users_histories" VALUES (3, 682);
INSERT INTO public."Users_histories" VALUES (3, 683);
INSERT INTO public."Users_histories" VALUES (3, 684);
INSERT INTO public."Users_histories" VALUES (3, 685);
INSERT INTO public."Users_histories" VALUES (13, 686);
INSERT INTO public."Users_histories" VALUES (13, 687);
INSERT INTO public."Users_histories" VALUES (13, 688);
INSERT INTO public."Users_histories" VALUES (13, 690);
INSERT INTO public."Users_histories" VALUES (13, 689);
INSERT INTO public."Users_histories" VALUES (13, 691);
INSERT INTO public."Users_histories" VALUES (13, 692);
INSERT INTO public."Users_histories" VALUES (13, 693);
INSERT INTO public."Users_histories" VALUES (13, 694);
INSERT INTO public."Users_histories" VALUES (13, 695);
INSERT INTO public."Users_histories" VALUES (3, 696);
INSERT INTO public."Users_histories" VALUES (3, 697);
INSERT INTO public."Users_histories" VALUES (3, 698);
INSERT INTO public."Users_histories" VALUES (3, 699);
INSERT INTO public."Users_histories" VALUES (13, 700);
INSERT INTO public."Users_histories" VALUES (13, 701);
INSERT INTO public."Users_histories" VALUES (3, 702);
INSERT INTO public."Users_histories" VALUES (3, 703);
INSERT INTO public."Users_histories" VALUES (3, 704);
INSERT INTO public."Users_histories" VALUES (3, 705);
INSERT INTO public."Users_histories" VALUES (3, 706);
INSERT INTO public."Users_histories" VALUES (3, 707);
INSERT INTO public."Users_histories" VALUES (3, 708);
INSERT INTO public."Users_histories" VALUES (3, 709);
INSERT INTO public."Users_histories" VALUES (3, 710);
INSERT INTO public."Users_histories" VALUES (3, 711);
INSERT INTO public."Users_histories" VALUES (3, 712);
INSERT INTO public."Users_histories" VALUES (3, 713);
INSERT INTO public."Users_histories" VALUES (3, 714);
INSERT INTO public."Users_histories" VALUES (3, 715);
INSERT INTO public."Users_histories" VALUES (3, 716);
INSERT INTO public."Users_histories" VALUES (3, 717);
INSERT INTO public."Users_histories" VALUES (3, 718);
INSERT INTO public."Users_histories" VALUES (3, 719);
INSERT INTO public."Users_histories" VALUES (3, 720);
INSERT INTO public."Users_histories" VALUES (3, 721);
INSERT INTO public."Users_histories" VALUES (13, 722);
INSERT INTO public."Users_histories" VALUES (13, 723);
INSERT INTO public."Users_histories" VALUES (13, 724);
INSERT INTO public."Users_histories" VALUES (13, 725);
INSERT INTO public."Users_histories" VALUES (13, 726);
INSERT INTO public."Users_histories" VALUES (13, 727);
INSERT INTO public."Users_histories" VALUES (13, 728);
INSERT INTO public."Users_histories" VALUES (13, 729);
INSERT INTO public."Users_histories" VALUES (13, 730);
INSERT INTO public."Users_histories" VALUES (13, 731);
INSERT INTO public."Users_histories" VALUES (13, 732);
INSERT INTO public."Users_histories" VALUES (13, 733);
INSERT INTO public."Users_histories" VALUES (13, 734);
INSERT INTO public."Users_histories" VALUES (13, 735);
INSERT INTO public."Users_histories" VALUES (13, 736);
INSERT INTO public."Users_histories" VALUES (13, 737);
INSERT INTO public."Users_histories" VALUES (13, 738);
INSERT INTO public."Users_histories" VALUES (13, 739);
INSERT INTO public."Users_histories" VALUES (13, 740);
INSERT INTO public."Users_histories" VALUES (3, 741);
INSERT INTO public."Users_histories" VALUES (3, 742);
INSERT INTO public."Users_histories" VALUES (3, 743);
INSERT INTO public."Users_histories" VALUES (3, 744);
INSERT INTO public."Users_histories" VALUES (3, 745);
INSERT INTO public."Users_histories" VALUES (3, 746);
INSERT INTO public."Users_histories" VALUES (3, 747);
INSERT INTO public."Users_histories" VALUES (3, 748);
INSERT INTO public."Users_histories" VALUES (3, 749);
INSERT INTO public."Users_histories" VALUES (3, 750);


--
-- TOC entry 3860 (class 0 OID 174540)
-- Dependencies: 315
-- Data for Name: tab1; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tab1 VALUES ('aaa', 10, 10, 10, 10, 10, 10, 10, 10, 10, 'nn', 'nn', 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 'yy', 'yy', 'yy', 'yy', '2020-02-15 00:00:00', 20, 50, 48, 584, 48, 555, 4, 'yy');
INSERT INTO public.tab1 VALUES ('bbb', 10, 10, 10, 10, 10, 10, 10, 10, 10, 'nn', 'nn', 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 'yy', 'yy', 'yy', 'yy', '2020-02-15 00:00:00', 20, 50, 48, 584, 48, 555, 4, 'yy');
INSERT INTO public.tab1 VALUES ('ccc', 10, 10, 10, 10, 10, 10, 10, 10, 10, 'nn', 'nn', 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 'yy', 'yy', 'yy', 'yy', '2020-02-15 00:00:00', 20, 50, 48, 584, 48, 555, 4, 'yy');
INSERT INTO public.tab1 VALUES ('ddd', 0, 0, 0, 0, 0, 0, 0, 0, 0, 'rrr', 'zzz', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'zzzz', 'zzz', 'zzz', 'zzz', '2020-02-15 00:00:00', 0, 0, 0, 0, 0, 0, 0, 'zzzz');
INSERT INTO public.tab1 VALUES ('eee', 0, 0, 0, 0, 0, 0, 0, 0, 0, 'rrr', 'zzz', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'zzzz', 'zzz', 'zzz', 'zzz', '2020-02-15 00:00:00', 0, 0, 0, 0, 0, 0, 0, 'zzzz');
INSERT INTO public.tab1 VALUES ('fff', 0, 0, 0, 0, 0, 0, 0, 0, 0, 'rrr', 'zzz', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'zzzz', 'zzz', 'zzz', 'zzz', '2020-02-15 00:00:00', 0, 0, 0, 0, 0, 0, 0, 'zzzz');
INSERT INTO public.tab1 VALUES ('ggg', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', '', '', '2020-02-15 00:00:00', 0, 0, 0, 0, 0, 0, 0, '');
INSERT INTO public.tab1 VALUES ('hhh', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', '', '', '2020-02-15 00:00:00', 0, 0, 0, 0, 0, 0, 0, '');


--
-- TOC entry 3861 (class 0 OID 174547)
-- Dependencies: 316
-- Data for Name: tab2; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tab2 VALUES ('aaa', 0, 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 0, 0, 'h', 'h', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('bbb', 0, 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 0, 0, 'h', 'h', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('ccc', 0, 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 0, 0, 'h', 'h', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('eee', 0, 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 0, 0, 'f', 'f', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('fff', 0, 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 0, 0, 'f', 'f', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('ddd', 0, 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 0, 0, 'f', 'f', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('ggg', 0, '', '', '', '', '', '', '', '', '', 0, 0, '', '', 0, '2020-02-15 00:00:00', 0);
INSERT INTO public.tab2 VALUES ('hhh', 0, '', '', '', '', '', '', '', '', '', 0, 0, '', '', 0, '2020-02-15 00:00:00', 0);


--
-- TOC entry 3888 (class 0 OID 0)
-- Dependencies: 306
-- Name: Attachement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Attachement_id_seq"', 357, true);


--
-- TOC entry 3889 (class 0 OID 0)
-- Dependencies: 308
-- Name: Chat_chat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Chat_chat_id_seq"', 4, true);


--
-- TOC entry 3890 (class 0 OID 0)
-- Dependencies: 317
-- Name: Classification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Classification_id_seq"', 13, true);


--
-- TOC entry 3891 (class 0 OID 0)
-- Dependencies: 300
-- Name: Composant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Composant_id_seq"', 19, true);


--
-- TOC entry 3892 (class 0 OID 0)
-- Dependencies: 321
-- Name: DownloadPin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."DownloadPin_id_seq"', 2, true);


--
-- TOC entry 3893 (class 0 OID 0)
-- Dependencies: 284
-- Name: Functions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Functions_id_seq"', 10, true);


--
-- TOC entry 3894 (class 0 OID 0)
-- Dependencies: 303
-- Name: History_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."History_id_seq"', 750, true);


--
-- TOC entry 3895 (class 0 OID 0)
-- Dependencies: 288
-- Name: Menu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Menu_id_seq"', 198, true);


--
-- TOC entry 3896 (class 0 OID 0)
-- Dependencies: 312
-- Name: Message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Message_id_seq"', 102, true);


--
-- TOC entry 3897 (class 0 OID 0)
-- Dependencies: 293
-- Name: Permissions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Permissions_id_seq"', 418, true);


--
-- TOC entry 3898 (class 0 OID 0)
-- Dependencies: 291
-- Name: Profile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Profile_id_seq"', 15, true);


--
-- TOC entry 3899 (class 0 OID 0)
-- Dependencies: 296
-- Name: Tree_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Tree_id_seq"', 6, true);


--
-- TOC entry 3900 (class 0 OID 0)
-- Dependencies: 286
-- Name: Url_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Url_id_seq"', 47, true);


--
-- TOC entry 3901 (class 0 OID 0)
-- Dependencies: 298
-- Name: Users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Users_id_seq"', 18, true);


--
-- TOC entry 3902 (class 0 OID 0)
-- Dependencies: 246
-- Name: account_perso_biat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_perso_biat_seq', 1, false);


--
-- TOC entry 3903 (class 0 OID 0)
-- Dependencies: 247
-- Name: account_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_seq', 1, false);


--
-- TOC entry 3904 (class 0 OID 0)
-- Dependencies: 248
-- Name: contrat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contrat_seq', 1, false);


--
-- TOC entry 3905 (class 0 OID 0)
-- Dependencies: 249
-- Name: customer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_seq', 1, false);


--
-- TOC entry 3906 (class 0 OID 0)
-- Dependencies: 250
-- Name: e_account_solde_perso_biat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_account_solde_perso_biat_seq', 1, false);


--
-- TOC entry 3907 (class 0 OID 0)
-- Dependencies: 251
-- Name: e_account_solde_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_account_solde_seq', 1, false);


--
-- TOC entry 3908 (class 0 OID 0)
-- Dependencies: 252
-- Name: e_contrat_perso_biat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_contrat_perso_biat_seq', 1, false);


--
-- TOC entry 3909 (class 0 OID 0)
-- Dependencies: 253
-- Name: e_currency_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_currency_seq', 1, false);


--
-- TOC entry 3910 (class 0 OID 0)
-- Dependencies: 254
-- Name: e_customer_relation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_customer_relation_seq', 1, false);


--
-- TOC entry 3911 (class 0 OID 0)
-- Dependencies: 255
-- Name: e_drawings_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_drawings_seq', 1, false);


--
-- TOC entry 3912 (class 0 OID 0)
-- Dependencies: 256
-- Name: e_encours_perso_biat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_encours_perso_biat_seq', 1, false);


--
-- TOC entry 3913 (class 0 OID 0)
-- Dependencies: 257
-- Name: e_lc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_lc_seq', 1, false);


--
-- TOC entry 3914 (class 0 OID 0)
-- Dependencies: 258
-- Name: e_ld_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_ld_seq', 1, false);


--
-- TOC entry 3915 (class 0 OID 0)
-- Dependencies: 259
-- Name: e_md_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_md_seq', 1, false);


--
-- TOC entry 3916 (class 0 OID 0)
-- Dependencies: 260
-- Name: e_mg_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_mg_seq', 1, false);


--
-- TOC entry 3917 (class 0 OID 0)
-- Dependencies: 261
-- Name: e_pd_detail_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_pd_detail_seq', 1, false);


--
-- TOC entry 3918 (class 0 OID 0)
-- Dependencies: 262
-- Name: e_pd_montant_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_pd_montant_seq', 1, false);


--
-- TOC entry 3919 (class 0 OID 0)
-- Dependencies: 263
-- Name: e_pd_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_pd_seq', 1, false);


--
-- TOC entry 3920 (class 0 OID 0)
-- Dependencies: 264
-- Name: e_titre_credit_echeancier_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_titre_credit_echeancier_seq', 1, false);


--
-- TOC entry 3921 (class 0 OID 0)
-- Dependencies: 265
-- Name: e_titre_credit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.e_titre_credit_seq', 1, false);


--
-- TOC entry 3922 (class 0 OID 0)
-- Dependencies: 266
-- Name: encours_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.encours_seq', 1, false);


--
-- TOC entry 3923 (class 0 OID 0)
-- Dependencies: 290
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 5, true);


--
-- TOC entry 3924 (class 0 OID 0)
-- Dependencies: 267
-- Name: p_typ_eng_bct_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.p_typ_eng_bct_seq', 1, false);


--
-- TOC entry 3925 (class 0 OID 0)
-- Dependencies: 268
-- Name: r_activite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_activite_seq', 1, false);


--
-- TOC entry 3926 (class 0 OID 0)
-- Dependencies: 269
-- Name: r_biat_profession_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_biat_profession_seq', 1, false);


--
-- TOC entry 3927 (class 0 OID 0)
-- Dependencies: 270
-- Name: r_category_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_category_seq', 1, false);


--
-- TOC entry 3928 (class 0 OID 0)
-- Dependencies: 271
-- Name: r_code_eng_bct_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_code_eng_bct_seq', 1, false);


--
-- TOC entry 3929 (class 0 OID 0)
-- Dependencies: 272
-- Name: r_code_eng_perso_biat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_code_eng_perso_biat_seq', 1, false);


--
-- TOC entry 3930 (class 0 OID 0)
-- Dependencies: 273
-- Name: r_code_eng_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_code_eng_seq', 1, false);


--
-- TOC entry 3931 (class 0 OID 0)
-- Dependencies: 274
-- Name: r_industry_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_industry_seq', 1, false);


--
-- TOC entry 3932 (class 0 OID 0)
-- Dependencies: 275
-- Name: r_limites_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_limites_seq', 1, false);


--
-- TOC entry 3933 (class 0 OID 0)
-- Dependencies: 276
-- Name: r_relation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_relation_seq', 1, false);


--
-- TOC entry 3934 (class 0 OID 0)
-- Dependencies: 277
-- Name: r_target_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_target_seq', 1, false);


--
-- TOC entry 3935 (class 0 OID 0)
-- Dependencies: 278
-- Name: r_type_credit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_type_credit_seq', 1, false);


--
-- TOC entry 3936 (class 0 OID 0)
-- Dependencies: 279
-- Name: r_type_encour_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_type_encour_seq', 1, false);


--
-- TOC entry 3937 (class 0 OID 0)
-- Dependencies: 280
-- Name: r_type_eng_md_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_type_eng_md_seq', 1, false);


--
-- TOC entry 3938 (class 0 OID 0)
-- Dependencies: 281
-- Name: r_type_eng_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_type_eng_seq', 1, false);


--
-- TOC entry 3939 (class 0 OID 0)
-- Dependencies: 282
-- Name: r_unitgest_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.r_unitgest_seq', 1, false);


--
-- TOC entry 3574 (class 2606 OID 149646)
-- Name: Attachement Attachement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Attachement"
    ADD CONSTRAINT "Attachement_pkey" PRIMARY KEY (id);


--
-- TOC entry 3576 (class 2606 OID 157821)
-- Name: Chat Chat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat"
    ADD CONSTRAINT "Chat_pkey" PRIMARY KEY (chat_id);


--
-- TOC entry 3590 (class 2606 OID 174695)
-- Name: Classification Classification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Classification"
    ADD CONSTRAINT "Classification_pkey" PRIMARY KEY (id);


--
-- TOC entry 3594 (class 2606 OID 174747)
-- Name: Client Client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Client"
    ADD CONSTRAINT "Client_pkey" PRIMARY KEY (account);


--
-- TOC entry 3566 (class 2606 OID 125102)
-- Name: Composant Composant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Composant"
    ADD CONSTRAINT "Composant_pkey" PRIMARY KEY (id);


--
-- TOC entry 3596 (class 2606 OID 184131)
-- Name: DownloadPin DownloadPin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."DownloadPin"
    ADD CONSTRAINT "DownloadPin_pkey" PRIMARY KEY (id);


--
-- TOC entry 3476 (class 2606 OID 58191)
-- Name: E_ACCOUNT_PERSO_BIAT E_ACCOUNT_PERSO_BIAT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_ACCOUNT_PERSO_BIAT"
    ADD CONSTRAINT "E_ACCOUNT_PERSO_BIAT_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3480 (class 2606 OID 58201)
-- Name: E_ACCOUNT_SOLDE_PERSO_BIAT E_ACCOUNT_SOLDE_PERSO_BIAT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_ACCOUNT_SOLDE_PERSO_BIAT"
    ADD CONSTRAINT "E_ACCOUNT_SOLDE_PERSO_BIAT_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3478 (class 2606 OID 58196)
-- Name: E_ACCOUNT_SOLDE E_ACCOUNT_SOLDE_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_ACCOUNT_SOLDE"
    ADD CONSTRAINT "E_ACCOUNT_SOLDE_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3474 (class 2606 OID 58184)
-- Name: E_ACCOUNT E_ACCOUNT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_ACCOUNT"
    ADD CONSTRAINT "E_ACCOUNT_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3484 (class 2606 OID 58215)
-- Name: E_CONTRAT_PERSO_BIAT E_CONTRAT_PERSO_BIAT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_CONTRAT_PERSO_BIAT"
    ADD CONSTRAINT "E_CONTRAT_PERSO_BIAT_pkey" PRIMARY KEY ("CDRCONTRH", "REF_CONT", "DATDEBVLD");


--
-- TOC entry 3482 (class 2606 OID 58208)
-- Name: E_CONTRAT E_CONTRAT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_CONTRAT"
    ADD CONSTRAINT "E_CONTRAT_pkey" PRIMARY KEY ("REF_CONT", "DATDEBVLD");


--
-- TOC entry 3486 (class 2606 OID 58220)
-- Name: E_CURRENCY E_CURRENCY_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_CURRENCY"
    ADD CONSTRAINT "E_CURRENCY_pkey" PRIMARY KEY ("CDR_CURR", "DATDEBVLD");


--
-- TOC entry 3488 (class 2606 OID 58225)
-- Name: E_CUSTOMER_RELATION E_CUSTOMER_RELATION_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_CUSTOMER_RELATION"
    ADD CONSTRAINT "E_CUSTOMER_RELATION_pkey" PRIMARY KEY ("ID", "RELT_CUST", "RELT_CODE", "DATDEBVLD");


--
-- TOC entry 3546 (class 2606 OID 58987)
-- Name: E_CUSTOMER E_CUSTOMER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_CUSTOMER"
    ADD CONSTRAINT "E_CUSTOMER_pkey" PRIMARY KEY ("CDRCUST", "DATDEBVLD");


--
-- TOC entry 3490 (class 2606 OID 58232)
-- Name: E_DRAWINGS E_DRAWINGS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_DRAWINGS"
    ADD CONSTRAINT "E_DRAWINGS_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3494 (class 2606 OID 58242)
-- Name: E_ENCOURS_PERSO_BIAT E_ENCOURS_PERSO_BIAT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_ENCOURS_PERSO_BIAT"
    ADD CONSTRAINT "E_ENCOURS_PERSO_BIAT_pkey" PRIMARY KEY ("CDRCONTRH", "REF_CONT", "CODE_TYP_ENCR", "STATUT", "DAT_SIT", "DAT_CHG");


--
-- TOC entry 3492 (class 2606 OID 58237)
-- Name: E_ENCOURS E_ENCOURS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_ENCOURS"
    ADD CONSTRAINT "E_ENCOURS_pkey" PRIMARY KEY ("REF_CONT", "CODE_TYP_ENCR", "STATUT", "DAT_SIT", "DAT_CHG");


--
-- TOC entry 3496 (class 2606 OID 58249)
-- Name: E_LC E_LC_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_LC"
    ADD CONSTRAINT "E_LC_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3498 (class 2606 OID 58256)
-- Name: E_LD E_LD_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_LD"
    ADD CONSTRAINT "E_LD_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3500 (class 2606 OID 58263)
-- Name: E_MD E_MD_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_MD"
    ADD CONSTRAINT "E_MD_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3502 (class 2606 OID 58270)
-- Name: E_MG E_MG_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_MG"
    ADD CONSTRAINT "E_MG_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3506 (class 2606 OID 58284)
-- Name: E_PD_DETAIL E_PD_DETAIL_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_PD_DETAIL"
    ADD CONSTRAINT "E_PD_DETAIL_pkey" PRIMARY KEY ("ID", "DAT_SIT", "DATCHG");


--
-- TOC entry 3508 (class 2606 OID 58291)
-- Name: E_PD_MONTANT E_PD_MONTANT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_PD_MONTANT"
    ADD CONSTRAINT "E_PD_MONTANT_pkey" PRIMARY KEY ("ID", "DAT_SIT");


--
-- TOC entry 3504 (class 2606 OID 58277)
-- Name: E_PD E_PD_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_PD"
    ADD CONSTRAINT "E_PD_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3512 (class 2606 OID 58303)
-- Name: E_TITRE_CREDIT_ECHEANCIER E_TITRE_CREDIT_ECHEANCIER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_TITRE_CREDIT_ECHEANCIER"
    ADD CONSTRAINT "E_TITRE_CREDIT_ECHEANCIER_pkey" PRIMARY KEY ("REF_TITR", "NUM_ECHN", "DATDEBVLD");


--
-- TOC entry 3510 (class 2606 OID 58298)
-- Name: E_TITRE_CREDIT E_TITRE_CREDIT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."E_TITRE_CREDIT"
    ADD CONSTRAINT "E_TITRE_CREDIT_pkey" PRIMARY KEY ("CDR_TITR", "REF_TITRE", "DATDEBVLD");


--
-- TOC entry 3548 (class 2606 OID 59024)
-- Name: Functions Functions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Functions"
    ADD CONSTRAINT "Functions_pkey" PRIMARY KEY (id);


--
-- TOC entry 3570 (class 2606 OID 133223)
-- Name: History History_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."History"
    ADD CONSTRAINT "History_pkey" PRIMARY KEY (id);


--
-- TOC entry 3552 (class 2606 OID 100074)
-- Name: Menu Menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu"
    ADD CONSTRAINT "Menu_pkey" PRIMARY KEY (id);


--
-- TOC entry 3582 (class 2606 OID 174284)
-- Name: Message Message_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Message"
    ADD CONSTRAINT "Message_pkey" PRIMARY KEY (id);


--
-- TOC entry 3514 (class 2606 OID 58313)
-- Name: P_TYP_ENG_BCT P_TYP_ENG_BCT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."P_TYP_ENG_BCT"
    ADD CONSTRAINT "P_TYP_ENG_BCT_pkey" PRIMARY KEY ("TYPE_ENCR", "TYPE_ENG", "DATDEBVLD");


--
-- TOC entry 3558 (class 2606 OID 108558)
-- Name: Permissions Permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Permissions"
    ADD CONSTRAINT "Permissions_pkey" PRIMARY KEY (id);


--
-- TOC entry 3554 (class 2606 OID 108452)
-- Name: Profile Profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profile"
    ADD CONSTRAINT "Profile_pkey" PRIMARY KEY (id);


--
-- TOC entry 3516 (class 2606 OID 58318)
-- Name: R_ACTIVITE R_ACTIVITE_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_ACTIVITE"
    ADD CONSTRAINT "R_ACTIVITE_pkey" PRIMARY KEY ("CDRACTV", "ID", "DATDEBVLD");


--
-- TOC entry 3518 (class 2606 OID 58323)
-- Name: R_BIAT_PROFESSION R_BIAT_PROFESSION_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_BIAT_PROFESSION"
    ADD CONSTRAINT "R_BIAT_PROFESSION_pkey" PRIMARY KEY ("CDRBIATPRFS", "ID", "DATDEBVLD");


--
-- TOC entry 3520 (class 2606 OID 58328)
-- Name: R_CATEGORY R_CATEGORY_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_CATEGORY"
    ADD CONSTRAINT "R_CATEGORY_pkey" PRIMARY KEY ("CDRCATG", "ID", "DATDEBVLD");


--
-- TOC entry 3524 (class 2606 OID 58340)
-- Name: R_CODE_ENG_BCT R_CODE_ENG_BCT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_CODE_ENG_BCT"
    ADD CONSTRAINT "R_CODE_ENG_BCT_pkey" PRIMARY KEY ("CDRCODENGBCT", "CODE_BCT", "DATDEBVLD");


--
-- TOC entry 3526 (class 2606 OID 58345)
-- Name: R_CODE_ENG_PERSO_BIAT R_CODE_ENG_PERSO_BIAT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_CODE_ENG_PERSO_BIAT"
    ADD CONSTRAINT "R_CODE_ENG_PERSO_BIAT_pkey" PRIMARY KEY ("CDRCODENGRH", "CODE_ENGG", "DATDEBVLD");


--
-- TOC entry 3522 (class 2606 OID 58335)
-- Name: R_CODE_ENG R_CODE_ENG_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_CODE_ENG"
    ADD CONSTRAINT "R_CODE_ENG_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3528 (class 2606 OID 58350)
-- Name: R_INDUSTRY R_INDUSTRY_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_INDUSTRY"
    ADD CONSTRAINT "R_INDUSTRY_pkey" PRIMARY KEY ("CDRINDS", "ID", "DATDEBVLD");


--
-- TOC entry 3530 (class 2606 OID 58355)
-- Name: R_LIMITES R_LIMITES_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_LIMITES"
    ADD CONSTRAINT "R_LIMITES_pkey" PRIMARY KEY ("CDRLIMT", "DATDEBVLD");


--
-- TOC entry 3532 (class 2606 OID 58362)
-- Name: R_RELATION R_RELATION_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_RELATION"
    ADD CONSTRAINT "R_RELATION_pkey" PRIMARY KEY ("CDRRELT", "ID", "DATDEBVLD");


--
-- TOC entry 3534 (class 2606 OID 58367)
-- Name: R_TARGET R_TARGET_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_TARGET"
    ADD CONSTRAINT "R_TARGET_pkey" PRIMARY KEY ("CDRTARG", "ID", "DATDEBVLD");


--
-- TOC entry 3536 (class 2606 OID 58374)
-- Name: R_TYPE_CREDIT R_TYPE_CREDIT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_TYPE_CREDIT"
    ADD CONSTRAINT "R_TYPE_CREDIT_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3538 (class 2606 OID 58379)
-- Name: R_TYPE_ENCOUR R_TYPE_ENCOUR_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_TYPE_ENCOUR"
    ADD CONSTRAINT "R_TYPE_ENCOUR_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3542 (class 2606 OID 58393)
-- Name: R_TYPE_ENG_MD R_TYPE_ENG_MD_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_TYPE_ENG_MD"
    ADD CONSTRAINT "R_TYPE_ENG_MD_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3540 (class 2606 OID 58386)
-- Name: R_TYPE_ENG R_TYPE_ENG_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_TYPE_ENG"
    ADD CONSTRAINT "R_TYPE_ENG_pkey" PRIMARY KEY ("ID", "DATDEBVLD");


--
-- TOC entry 3544 (class 2606 OID 58400)
-- Name: R_UNITGEST R_UNITGEST_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."R_UNITGEST"
    ADD CONSTRAINT "R_UNITGEST_pkey" PRIMARY KEY ("CDR_UNIT_GEST", "DATDEBVLD");


--
-- TOC entry 3562 (class 2606 OID 116839)
-- Name: Tree Tree_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tree"
    ADD CONSTRAINT "Tree_pkey" PRIMARY KEY (id);


--
-- TOC entry 3550 (class 2606 OID 75511)
-- Name: Url Url_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Url"
    ADD CONSTRAINT "Url_pkey" PRIMARY KEY (id);


--
-- TOC entry 3564 (class 2606 OID 116860)
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id);


--
-- TOC entry 3586 (class 2606 OID 174546)
-- Name: tab1 tab1_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tab1
    ADD CONSTRAINT tab1_pkey PRIMARY KEY (cpte);


--
-- TOC entry 3588 (class 2606 OID 174553)
-- Name: tab2 tab2_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tab2
    ADD CONSTRAINT tab2_pkey PRIMARY KEY (cpte);


--
-- TOC entry 3568 (class 2606 OID 125107)
-- Name: Menu_composants uk_4s7xnuq31hy4s4rt9ab855m91; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu_composants"
    ADD CONSTRAINT uk_4s7xnuq31hy4s4rt9ab855m91 UNIQUE (composants_id);


--
-- TOC entry 3580 (class 2606 OID 157851)
-- Name: Chat_users uk_6cmecmd1uc3ek8c43rr24i9r4; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat_users"
    ADD CONSTRAINT uk_6cmecmd1uc3ek8c43rr24i9r4 UNIQUE (users_id);


--
-- TOC entry 3584 (class 2606 OID 174289)
-- Name: Message_attachements uk_ijnbeuhsbci60qac02i6wnyn7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Message_attachements"
    ADD CONSTRAINT uk_ijnbeuhsbci60qac02i6wnyn7 UNIQUE (attachements_id);


--
-- TOC entry 3556 (class 2606 OID 108454)
-- Name: Profile uk_lnshvq7oeu6q45bkaglr96l4u; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profile"
    ADD CONSTRAINT uk_lnshvq7oeu6q45bkaglr96l4u UNIQUE (profiletype);


--
-- TOC entry 3592 (class 2606 OID 174700)
-- Name: Classification_attachements uk_ml2cefoli5usr82nlx0ie57co; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Classification_attachements"
    ADD CONSTRAINT uk_ml2cefoli5usr82nlx0ie57co UNIQUE (attachements_id);


--
-- TOC entry 3560 (class 2606 OID 108668)
-- Name: Profile_permissions uk_odqprvyva63st6s7jdvu96x1m; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profile_permissions"
    ADD CONSTRAINT uk_odqprvyva63st6s7jdvu96x1m UNIQUE (permissions_id);


--
-- TOC entry 3572 (class 2606 OID 133228)
-- Name: Users_histories uk_sgkw5wctf49c4eeyljh2ki9fv; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users_histories"
    ADD CONSTRAINT uk_sgkw5wctf49c4eeyljh2ki9fv UNIQUE (histories_id);


--
-- TOC entry 3578 (class 2606 OID 157849)
-- Name: Chat_messages uk_tf5eu6njojkamaviytdswgm4r; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat_messages"
    ADD CONSTRAINT uk_tf5eu6njojkamaviytdswgm4r UNIQUE (messages_id);


--
-- TOC entry 3597 (class 2606 OID 108565)
-- Name: Permissions fk1x8wp8tfim2xuvga4q2fk647f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Permissions"
    ADD CONSTRAINT fk1x8wp8tfim2xuvga4q2fk647f FOREIGN KEY (menu_id) REFERENCES public."Menu"(id);


--
-- TOC entry 3601 (class 2606 OID 125113)
-- Name: Menu_composants fk3i8404sucxq2fhy2qgj98bs32; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu_composants"
    ADD CONSTRAINT fk3i8404sucxq2fhy2qgj98bs32 FOREIGN KEY ("Menu_id") REFERENCES public."Menu"(id);


--
-- TOC entry 3602 (class 2606 OID 125108)
-- Name: Menu_composants fk3ioy73dssnefgcu9lsmae4uxm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu_composants"
    ADD CONSTRAINT fk3ioy73dssnefgcu9lsmae4uxm FOREIGN KEY (composants_id) REFERENCES public."Composant"(id);


--
-- TOC entry 3605 (class 2606 OID 157871)
-- Name: Chat_messages fk4tdieqfmb4i99i47xbm20fnmk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat_messages"
    ADD CONSTRAINT fk4tdieqfmb4i99i47xbm20fnmk FOREIGN KEY ("Chat_chat_id") REFERENCES public."Chat"(chat_id);


--
-- TOC entry 3611 (class 2606 OID 174748)
-- Name: Classification fk5y2hmstd9ps2ms1qc5i50iw1o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Classification"
    ADD CONSTRAINT fk5y2hmstd9ps2ms1qc5i50iw1o FOREIGN KEY (client_account) REFERENCES public."Client"(account);


--
-- TOC entry 3603 (class 2606 OID 133229)
-- Name: Users_histories fk67y7d9hauiepvdn29fldmx3rw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users_histories"
    ADD CONSTRAINT fk67y7d9hauiepvdn29fldmx3rw FOREIGN KEY (histories_id) REFERENCES public."History"(id);


--
-- TOC entry 3598 (class 2606 OID 108626)
-- Name: Profile_permissions fk6prjc03opw6tn97s3feu805r9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profile_permissions"
    ADD CONSTRAINT fk6prjc03opw6tn97s3feu805r9 FOREIGN KEY ("Profile_id") REFERENCES public."Profile"(id);


--
-- TOC entry 3614 (class 2606 OID 184132)
-- Name: DownloadPin fk7tk4f66h9sxo151r4mle0m43m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."DownloadPin"
    ADD CONSTRAINT fk7tk4f66h9sxo151r4mle0m43m FOREIGN KEY (user_id) REFERENCES public."Users"(id);


--
-- TOC entry 3604 (class 2606 OID 133234)
-- Name: Users_histories fk8ow1r8llrggtyrqcng6givrun; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users_histories"
    ADD CONSTRAINT fk8ow1r8llrggtyrqcng6givrun FOREIGN KEY ("User_id") REFERENCES public."Users"(id);


--
-- TOC entry 3609 (class 2606 OID 174295)
-- Name: Message_attachements fkbjf5898toavmieoagbg19yhoe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Message_attachements"
    ADD CONSTRAINT fkbjf5898toavmieoagbg19yhoe FOREIGN KEY (attachements_id) REFERENCES public."Attachement"(id);


--
-- TOC entry 3607 (class 2606 OID 157881)
-- Name: Chat_users fkg8nufjattx9xwx5y4af2eu14n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat_users"
    ADD CONSTRAINT fkg8nufjattx9xwx5y4af2eu14n FOREIGN KEY ("Chat_chat_id") REFERENCES public."Chat"(chat_id);


--
-- TOC entry 3606 (class 2606 OID 175988)
-- Name: Chat_messages fkg90rnac3gm76g2k9sm59feh33; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat_messages"
    ADD CONSTRAINT fkg90rnac3gm76g2k9sm59feh33 FOREIGN KEY (messages_id) REFERENCES public."Message"(id);


--
-- TOC entry 3610 (class 2606 OID 174300)
-- Name: Message_attachements fkieh1ps4u6gh9i8pxv1a7my2oq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Message_attachements"
    ADD CONSTRAINT fkieh1ps4u6gh9i8pxv1a7my2oq FOREIGN KEY ("Message_id") REFERENCES public."Message"(id);


--
-- TOC entry 3599 (class 2606 OID 108621)
-- Name: Profile_permissions fkl6s931tws5bbxf0c76tud13k5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profile_permissions"
    ADD CONSTRAINT fkl6s931tws5bbxf0c76tud13k5 FOREIGN KEY (permissions_id) REFERENCES public."Permissions"(id);


--
-- TOC entry 3600 (class 2606 OID 116861)
-- Name: Users fkn1glh7dob8uuu87gdhc4yndba; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT fkn1glh7dob8uuu87gdhc4yndba FOREIGN KEY (profile) REFERENCES public."Profile"(profiletype);


--
-- TOC entry 3612 (class 2606 OID 174711)
-- Name: Classification_attachements fknbg8d24okgu7px9sxqiin9mqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Classification_attachements"
    ADD CONSTRAINT fknbg8d24okgu7px9sxqiin9mqo FOREIGN KEY (attachements_id) REFERENCES public."Attachement"(id);


--
-- TOC entry 3613 (class 2606 OID 174716)
-- Name: Classification_attachements fkpfcjqxembi7d2o1f5x5ymn1oa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Classification_attachements"
    ADD CONSTRAINT fkpfcjqxembi7d2o1f5x5ymn1oa FOREIGN KEY ("Classification_id") REFERENCES public."Classification"(id);


--
-- TOC entry 3608 (class 2606 OID 157876)
-- Name: Chat_users fkpvo8r5l7n83o8k6x7u1ae5vyl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Chat_users"
    ADD CONSTRAINT fkpvo8r5l7n83o8k6x7u1ae5vyl FOREIGN KEY (users_id) REFERENCES public."Users"(id);


-- Completed on 2023-05-01 22:40:12

--
-- PostgreSQL database dump complete
--

