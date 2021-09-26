module pl.wsb {
    requires javafx.controls;
    requires lombok;
    requires java.sql;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;
    exports pl.wsb.api;
    exports pl.wsb.model;
    exports pl.wsb.repository;
    exports pl.wsb.service;
    exports pl.wsb;
}