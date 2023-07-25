package com.erdemiryigit.mychatapp;

import java.util.Date;

public record ChatMessage(String from, String to, String text, Date time) {
}
