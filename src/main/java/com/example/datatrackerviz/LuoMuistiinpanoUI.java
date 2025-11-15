package com.example.datatrackerviz;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("luo")
public class LuoMuistiinpanoUI extends AppLayout {

    private final TehtavatService tehtavatService;

    public LuoMuistiinpanoUI(TehtavatService tehtavatService) {
        this.tehtavatService = tehtavatService;


        H1 title = new H1("Luo Muistiinpano");
        title.getStyle().set("margin", "0 auto").set("padding", "10px 0");
        addToNavbar(title);


        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setSpacing(true);


        TextField idField = new TextField("ID");
        idField.setWidth("90%");
        idField.setMaxWidth("400px");


        TextArea textField = new TextArea("Sisältö");
        textField.setWidth("90%");
        textField.setMaxWidth("400px");
        textField.setHeight("200px");


        Button saveButton = new Button("💾 Tallenna");
        saveButton.getStyle()
                .set("background-color", "var(--lumo-primary-color)")
                .set("color", "white")
                .set("padding", "12px 30px")
                .set("font-size", "16px")
                .set("border-radius", "12px");

        saveButton.addClickListener(e -> {
            if (idField.getValue() == null || idField.getValue().isEmpty()) {
                Notification.show("Anna ID!", 2000, Notification.Position.MIDDLE);
                return;
            }
            if (textField.getValue() == null || textField.getValue().isEmpty()) {
                Notification.show("Muistiinpano ei voi olla tyhjä!", 2000, Notification.Position.MIDDLE);
                return;
            }

            try {
                int id = Integer.parseInt(idField.getValue());
                String sisältö = textField.getValue();


                Tehtavat uusi = new Tehtavat(sisältö, false, id);
                tehtavatService.uusiTehtava(id, uusi);

                Notification.show("Tallennettu! ✔", 3000, Notification.Position.MIDDLE);
                UI.getCurrent().navigate("main");

            } catch (NumberFormatException ex) {
                Notification.show("ID täytyy olla numero!", 2000, Notification.Position.MIDDLE);
            }
        });

        layout.add(idField, textField, saveButton);
        setContent(layout);
    }
}
