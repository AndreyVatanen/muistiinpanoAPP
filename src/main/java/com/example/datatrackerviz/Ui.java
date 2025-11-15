package com.example.datatrackerviz;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Map;

@Route("main")
public class Ui extends AppLayout {
    private final TehtavatService tehtavatService;

    public Ui(TehtavatService tehtavatService) {
        this.tehtavatService = tehtavatService;


        H1 title = new H1("Muistio");
        title.getStyle()
                .set("margin", "0 auto")
                .set("padding", "10px 0")
                .set("text-align", "center")
                .setColor("BLACK");
        addToNavbar(title);


        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        content.setSpacing(true);


        H2 listTitle = new H2("Muistiinpanot");
        listTitle.getStyle().set("margin-top", "20px");


        Div noteList = new Div();
        noteList.getStyle()
                .set("border", "1px solid var(--lumo-contrast-20pct)")
                .set("border-radius", "12px")
                .set("padding", "15px")
                .set("width", "90%")
                .set("max-width", "600px")
                .set("background-color", "var(--lumo-base-color)");


        for (Map.Entry<Integer, Tehtavat> entry : tehtavatService.kaikkiTehtavat().entrySet()) {
            Integer id = entry.getKey();
            Tehtavat tehtava = entry.getValue();

            Div card = new Div();
            card.getStyle()
                    .set("display", "flex")
                    .set("align-items", "center")
                    .set("justify-content", "space-between")
                    .set("padding", "8px 12px")
                    .set("margin-bottom", "8px")
                    .set("border-radius", "8px")
                    .set("background-color", "var(--lumo-contrast-5pct)");


            Checkbox doneBox = new Checkbox();
            doneBox.setLabel(id + ": " + tehtava.getTehtava());


            doneBox.addValueChangeListener(event -> {
                if (Boolean.TRUE.equals(event.getValue())) {
                    tehtavatService.poistaTehtava(id);
                    noteList.remove(card);
                    Notification.show("Tehtävä '" + tehtava.getTehtava() + "' merkitty tehdyksi ja poistettu.");
                }
            });

            card.add(doneBox);
            noteList.add(card);
        }


        Button addBtn = new Button("➕ Lisää muistiinpano");
        addBtn.getStyle()
                .set("background-color", "var(--lumo-success-color)")
                .set("color", "white")
                .set("padding", "12px 24px")
                .set("font-size", "16px")
                .set("border-radius", "12px");
        addBtn.addClickListener(e -> UI.getCurrent().navigate(LuoMuistiinpanoUI.class));


        Button refreshBtn = new Button("🔄 Päivitä");
        refreshBtn.getStyle()
                .set("background-color", "var(--lumo-primary-color)")
                .set("color", "white")
                .set("padding", "12px 24px")
                .set("font-size", "16px")
                .set("border-radius", "12px");
        refreshBtn.addClickListener(e -> UI.getCurrent().getPage().reload());


        content.add(listTitle, noteList, addBtn, refreshBtn);
        setContent(content);
    }
}
