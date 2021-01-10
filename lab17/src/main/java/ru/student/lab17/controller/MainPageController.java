package ru.student.lab17.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

@Controller
@FxmlView("main-page.fxml")
public class MainPageController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ListView<?> basket;

    @FXML
    private ListView<?> products;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button clearButton;
}
