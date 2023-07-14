package com.example.test.view;

import com.example.test.entity.LoggingСhanges;
import com.example.test.service.LoggingChangesService;
import com.vaadin.flow.component.button.Button;;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;



@Route("main")
public class MainView extends VerticalLayout {

    private final LoggingChangesService loggingChangesService;
    private final TextField textField;
    private final Button button;
    private final Binder<LoggingСhanges> binder;

    public MainView(LoggingChangesService loggingChangesService) {
        this.loggingChangesService = loggingChangesService;
        this.textField = new TextField();
        textField.setReadOnly(true);
        textField.setLabel("Latest data:");
        this.button = new Button("Click");
        this.binder = new Binder<>(LoggingСhanges.class);
        binder.forField(textField)
                .bindReadOnly(LoggingСhanges::toString);
        binder.readBean(loggingChangesService.findFirstByOrderByIdDesc());

        button.addClickListener(e -> {
                loggingChangesService.incrementCount();
                binder.readBean(loggingChangesService.findFirstByOrderByIdDesc());
            }
        );

        add(textField, button);
    }
}
