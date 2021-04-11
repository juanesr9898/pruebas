package co.edu.utp.isc.gia.pruebas.exceptions;

import java.util.Date;
import lombok.Getter;

@Getter
public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;
  private String httpCodeMessage;

  public ExceptionResponse(Date timestamp, String message, String details,String httpCodeMessage) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
    this.httpCodeMessage = httpCodeMessage;
  }
}