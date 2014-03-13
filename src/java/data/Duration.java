/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * A duration between two times.
 *
 * @author Benjamin
 */
@Embeddable
public class Duration implements Serializable {

  @NotNull
  @Temporal(TemporalType.DATE)
  private Date start;
  @NotNull
  @Temporal(TemporalType.DATE)
  private Date finish;

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getFinish() {
    return finish;
  }

  public void setFinish(Date finish) {
    this.finish = finish;
  }

  public Duration() {
  }

  public Duration(Date start, Date finish) {
    this.start = start;
    this.finish = finish;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 41 * hash + Objects.hashCode(this.start);
    hash = 41 * hash + Objects.hashCode(this.finish);
    return hash;
  }

  @Override
  public String toString() {
    return "Starting on " + start + " and ending on " + finish;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Duration other = (Duration) obj;
    if (!Objects.equals(this.start, other.start)) {
      return false;
    }
    if (!Objects.equals(this.finish, other.finish)) {
      return false;
    }
    return true;
  }

}
