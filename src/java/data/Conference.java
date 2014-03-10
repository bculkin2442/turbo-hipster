/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class Conference {

  private String cde;
  private String loc;
  private Day begin;
  private Day end;

  public Conference() {
  }

  public Conference(String cde, String loc, Day begin, Day end) {
    this.cde = cde;
    this.loc = loc;
    this.begin = begin;
    this.end = end;
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

  public Day getBegin() {
    return begin;
  }

  public void setBegin(Day begin) {
    this.begin = begin;
  }

  public Day getEnd() {
    return end;
  }

  public void setEnd(Day end) {
    this.end = end;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.cde);
    hash = 83 * hash + Objects.hashCode(this.loc);
    hash = 83 * hash + Objects.hashCode(this.begin);
    hash = 83 * hash + Objects.hashCode(this.end);
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
            + loc + " starting on " + begin + " and ending on " + end;
  }

}
