/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import validation.Following;

/**
 * A conference held in a specific place between two times.
 *
 * @author Benjamin
 */
@NamedQuery(name = "getAllConferences", query = "SELECT c FROM Conference c")
@Entity
public class Conference implements Serializable {

  @Id
  @NotNull(message = "Conference must be given a code name.")
  private String cde;
  @NotNull(message = "Conference must take place somewhere.")
  private String loc;
  @NotNull(message = "Conference must have a time it takes place.")
  @Following(message = "Conference must start before it ends.")
  @Embedded
  private Duration dur;

  public Conference() {
  }

  public Conference(String cde, String loc, Duration durn) {
    this.cde = cde;
    this.loc = loc;
    this.dur = durn;
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

  public Duration getDur() {
    return dur;
  }

  public void setDur(Duration dur) {
    this.dur = dur;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.cde);
    hash = 83 * hash + Objects.hashCode(this.loc);
    hash = 83 * hash + Objects.hashCode(this.dur);
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
    return Objects.equals(this.cde, other.cde);
  }

  @Override
  public String toString() {
    return "Conference code named " + cde + " is taking place in "
            + loc + dur;
  }

}
