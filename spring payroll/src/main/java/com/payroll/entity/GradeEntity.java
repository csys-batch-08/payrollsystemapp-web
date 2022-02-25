package com.payroll.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.payroll.model.Departments;

@Entity
@Table(name="grades")
public class GradeEntity {
	@Id
	@Column(name="GRADE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeId;
	
	@Column(name = "DEPT_ID")
	private Departments department;
	
	@Column(name="GRADE_NAME")
	private String gradeName;
	
	@Column(name="GRADE_BONUS")
	private long gradeBonus;
	
	@Column(name="GRADE_BASIC")
	private long gradeBasic;
	
	@Column(name="GRADE_PF")
	private long gradePf;
	
	@Column(name="GRADE_PT")
	private long gradePt;

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public long getGradeBonus() {
		return gradeBonus;
	}

	public void setGradeBonus(long gradeBonus) {
		this.gradeBonus = gradeBonus;
	}

	public long getGradeBasic() {
		return gradeBasic;
	}

	public void setGradeBasic(long gradeBasic) {
		this.gradeBasic = gradeBasic;
	}

	public long getGradePf() {
		return gradePf;
	}

	public void setGradePf(long gradePf) {
		this.gradePf = gradePf;
	}

	public long getGradePt() {
		return gradePt;
	}

	public void setGradePt(long gradePt) {
		this.gradePt = gradePt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, gradeBasic, gradeBonus, gradeId, gradeName, gradePf, gradePt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradeEntity other = (GradeEntity) obj;
		return Objects.equals(department, other.department) && gradeBasic == other.gradeBasic
				&& gradeBonus == other.gradeBonus && gradeId == other.gradeId
				&& Objects.equals(gradeName, other.gradeName) && gradePf == other.gradePf && gradePt == other.gradePt;
	}

	public GradeEntity(int gradeId, Departments department, String gradeName, long gradeBonus, long gradeBasic,
			long gradePf, long gradePt) {
		super();
		this.gradeId = gradeId;
		this.department = department;
		this.gradeName = gradeName;
		this.gradeBonus = gradeBonus;
		this.gradeBasic = gradeBasic;
		this.gradePf = gradePf;
		this.gradePt = gradePt;
	}

	@Override
	public String toString() {
		return "GradeEntity [gradeId=" + gradeId + ", department=" + department + ", gradeName=" + gradeName
				+ ", gradeBonus=" + gradeBonus + ", gradeBasic=" + gradeBasic + ", gradePf=" + gradePf + ", gradePt="
				+ gradePt + "]";
	}

	public GradeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
