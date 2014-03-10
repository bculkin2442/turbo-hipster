/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Benjamin
 */
@Entity
public class Conference implements Serializable {

  @Id
  private String cde;
  @NotNull
  private String loc;
  @NotNull
  @Temporal(TemporalType.DATE)
  @Future
  private Date start;
  @NotNull
  @Temporal(TemporalType.DATE)
  @Future
  private Date finish;

  public Conference() {
  }

  public Conference(String cde, String loc, Date begin, Date end) {
    this.cde = cde;
    this.loc = loc;
    this.start = begin;
    this.finish = end;
  }

  public String getCde() {
    return cde;
  }

  public void setCde(String cde) {
    this.cde = cde;
  }

  public String getLoc() {
    return loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date begin) {
    this.start = begin;
  }

  public Date getFinish() {
    return finish;
  }

  public void setFinish(Date end) {
    this.finish = end;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.cde);
    hash = 83 * hash + Objects.hashCode(this.loc);
    hash = 83 * hash + Objects.hashCode(this.start);
    hash = 83 * hash + Objects.hashCode(this.finish);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Conference other = (Conference) obj;
    if (!Objects.equals(this.cde, other.cde)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Conference code named " + cde + " is taking place in "
            + loc + " starting on " + start + " and ending on " + finish;
  }

}
