/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

/**
 * A duration between two times. At least for this project, both are in the
 * future
 *
 * @author Benjamin
 */
@Embeddable
public class Duration implements Serializable {

  @NotNull
  @Temporal(TemporalType.DATE)
  @Future
  private Date start;
  @NotNull
  @Temporal(TemporalType.DATE)
  @Future
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

}
