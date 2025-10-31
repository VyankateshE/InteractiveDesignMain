package org.example;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "log_data")
public class LogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "send_request_time")
    private Date sendRequestTime;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "result")
    private String result;
    @Column(name = "error_message")
    private String error_message;
    @Column(name = "output_response_time")
    private Date outputResponseTime;
    @Column(name = "type_requested")
    private String typeRequested;
    @Column(name = "which_app_request_sent_by")
    private String whichAppRequestSentBy;

}

