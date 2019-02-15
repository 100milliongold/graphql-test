package hello;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.leangen.graphql.annotations.GraphQLQuery;


@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @GraphQLQuery(name = "id", description = "A user's id")
    private Integer id;
    @GraphQLQuery(name = "name", description = "A user's name")
    private String name;
    @GraphQLQuery(name = "email", description = "A user's email")
    private String email;

    @Lob
    @GraphQLQuery(name = "comment", description = "user massage")
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}


}
