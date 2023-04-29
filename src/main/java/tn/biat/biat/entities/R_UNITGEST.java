package tn.biat.biat.entities;
import lombok.*;
import tn.biat.biat.entities.pk.R_UNITGEST_pk;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(R_UNITGEST_pk.class)
@Entity
@Table(name = "\"R_UNITGEST\"", schema = "public")
@SequenceGenerator(schema = "public", name = "R_UNITGEST_seq", allocationSize = 1, sequenceName = "R_UNITGEST_seq")
public class R_UNITGEST implements Serializable{

	@Id
	@Column(name = "CDR_UNIT_GEST")
	@GeneratedValue(generator = "R_UNITGEST_seq", strategy = GenerationType.SEQUENCE)
	private int CDR_UNIT_GEST;

	@Column(name = "ID")
	private String ID;
	@Column(name = "AREA")
	private String AREA;
	@Column(name = "NAME")
	private String NAME;
	@Column(name = "TELEPHONE_NO")
	private String TELEPHONE_NO;
	@Column(name = "RECORD_STATUS")
	private String RECORD_STATUS;
	@Column(name = "CO_CODE")
	private String CO_CODE;
	@Column(name = "DEPT_LEVEL")
	private String DEPT_LEVEL;
	@Column(name = "CODE_AGENCE")
	private String CODE_AGENCE;
	@Column(name = "CODE_AGENCE_BCT")
	private String CODE_AGENCE_BCT;
	@Column(name = "CODE_AGENCE_RIB")
	private String CODE_AGENCE_RIB;
	@Column(name = "CODE_COMPANY")
	private String CODE_COMPANY;
	@Column(name = "ATQ_WU")
	private String ATQ_WU;
	@Column(name = "LR_LONGITUDE")
	private String LR_LONGITUDE;
	@Column(name = "LR_LATITUDE")
	private String LR_LATITUDE;
	@Column(name = "LR_GOUVERNERAT")
	private String LR_GOUVERNERAT;
	@Column(name = "TYPE_AGENCE")
	private String TYPE_AGENCE;
	@Column(name = "CLSS")
	private String CLSS;
	@Column(name = "DATE_OUVT")
	private String DATE_OUVT;

	@Column(name = "DEPT_PARENT")
	private int DEPT_PARENT;

	@Id
	@Column(name = "DATDEBVLD")
	@GeneratedValue(generator = "R_UNITGEST_seq", strategy = GenerationType.SEQUENCE)
	private int DATDEBVLD;

	@Column(name = "DATFINVLD")
	private int DATFINVLD;
	@Column(name = "DERSIT")
	private int DERSIT;
	@Column(name = "DATCHG")
	private int DATCHG;
}
