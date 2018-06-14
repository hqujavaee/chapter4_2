package cn.edu.hqu.javaee.chapter4_2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Getter
	@Setter
	@Column(name="message",length=2000)
	private String message;
	
	@Getter
	@Setter
	@Column(name="postedTime")
	@Temporal(value=TemporalType.DATE)
	@NotEmpty
	private Date postedTime;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="username",  nullable = false) 
	private Hquer hquer;
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"id","postedTime");
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","postedTime");
	}

}
