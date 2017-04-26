package com.proj.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class utils {

	public String dateNow() {

		LocalDate current_date = LocalDate.now().plusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd");

		System.out.println("current Date:" + current_date.format(formatter));
		return current_date.format(formatter);
	}

	public String datePlusWeek() {

		LocalDate date = LocalDate.now().plusDays(2).plusWeeks(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd");

		System.out.println("Current date + week:" + date.format(formatter));
		return date.format(formatter);
	}

	public void sendEmail(String title, String price) {

		final String username = "selinium.service@gmail.com";
		final String password = "today@123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("southwest@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("selinium.service@gmail.com"));
			message.setSubject("Hurray!!!! Your Flight is Booked");
			message.setText("Enjoy your Trip...," + "\n\n" + "\n\n " + title + "" + "\n\n " + price);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
