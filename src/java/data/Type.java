/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Benjamin
 */
@Entity
public class Type {

  @Id
  private String code;
  @NotNull
  private String desc;

  public Type() {
  }

  public Type(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.code);
    hash = 37 * hash + Objects.hashCode(this.desc);
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
    final Type other = (Type) obj;
    if (!Objects.equals(this.code, other.code)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Type abbreviated as" + code + "is described by" + desc;
  }

}
