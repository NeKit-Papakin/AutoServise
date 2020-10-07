package sample;

import java.net.URL;
import java.security.cert.X509CertSelector;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.ClientDAO;
import dao.ServiceDAO;
import dao.WorkerDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import tables.Client;
import tables.Services;
import tables.Worker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {

    public class Invoice {
        private String service;
        private double price;

        public Invoice(String service, double price) {
            this.service = service;
            this.price = price;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private TextField secondNameClientTextField;
    @FXML private TextField firstNameClientTextField;
    @FXML private TextField middleNameClientTextField;
    @FXML private TextField phoneClientTextField;
    @FXML private TextField driversLicenceNumTextField;
    @FXML private TextField carModelClientTextField;
    @FXML private Button addClientRecordButton;
    @FXML private Label addClientServiceLabel;
    @FXML private TextField serviceTitleTextField;
    @FXML private TextField serviceTypeTextField;
    @FXML private TextField servicePriceTextField;
    @FXML private Button addServiceRecordButton;
    @FXML private Label addServiceResultLabel;
    @FXML private TextField secondNameWorkerTextField;
    @FXML private TextField firstNameWorkerTextField;
    @FXML private TextField middleNameWorkerTextField;
    @FXML private TextField phoneWorkerTextField;
    @FXML private TextField ddTextField;
    @FXML private TextField mmTextField;
    @FXML private TextField yyyyTextField;
    @FXML private TextField occupationWorkerTextField;
    @FXML private TextField salaryWorkerTextField;
    @FXML private Button addWorkerRecordButton;
    @FXML private Label addWorkerResultLabel;
    @FXML private TableView<Invoice> servicesMakeInvoiceTable;
    @FXML private TableColumn<Invoice, String> makeInvoiceServiceColumn;
    @FXML private TableColumn<Invoice, Double> makeInvoiceServicePriceColumn;
    @FXML private TableView<Invoice> serviceInvoiceTable;
    @FXML private TableColumn<Invoice, String> invoiceServiceColumn;
    @FXML private TableColumn<Invoice, Double> invoiceServicePriceColumn;
    @FXML private Button makeInvoiceShowServicesButton;
    @FXML private Button addServiceToInvoiceButton;
    @FXML private Button makeInvoiceButton;
    @FXML private TableView<Client> clientTable;
    @FXML private TableColumn<Client, Integer> idClientColumn;
    @FXML private TableColumn<Client, String> secondNameClientColumn;
    @FXML private TableColumn<Client, String> firstNameClientColumn;
    @FXML private TableColumn<Client, String> middleNameClientColumn;
    @FXML private TableColumn<Client, String> phoneClientColumn;
    @FXML private TableColumn<Client, String> driverLicenceClientColumn;
    @FXML private TableColumn<Client, String> carModelClientColumn;
    @FXML private Button showAllClientsButton;
    @FXML private Button editClientSelectedRecordButton;
    @FXML private Button deleteClientSelectedRecordButton;
    @FXML private TableView<Services> servicesTable;
    @FXML private TableColumn<Services, Integer> idServiceColumn;
    @FXML private TableColumn<Services, String> serviceTitleColumn;
    @FXML private TableColumn<Services, String> serviceTypeColumn;
    @FXML private TableColumn<Services, String> servicePriceColumn;
    @FXML private Button showAllServicesButton;
    @FXML private Button editSelectedServiceRecordButton;
    @FXML private Button deleteSelectedServiceRecordButton;
    @FXML private TableView<Worker> workerTable;
    @FXML private TableColumn<Worker, Integer> idWorkerColumn;
    @FXML private TableColumn<Worker, String> secondNameWorkerColumn;
    @FXML private TableColumn<Worker, String> firstNameWorkerColumn;
    @FXML private TableColumn<Worker, String> middleNameWorkerColumn;
    @FXML private TableColumn<Worker, String> phoneWorkerColumn;
    @FXML private TableColumn<Worker, LocalDate> hiringDateWorkerColumn;
    @FXML private TableColumn<Worker, Double> salaryWorkerColumn;
    @FXML private TableColumn<Worker, String> occupationWorkerColumn;
    @FXML private Button showAllWorkersButton;
    @FXML private Button editSelectedWorkerRecordButton;
    @FXML private Button deleteSelectedWorkerRecordButton;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;
    private ClientDAO clientDAO;
    private WorkerDAO workerDAO;
    private ServiceDAO serviceDAO;
    private AlertWindow alertWindow = new AlertWindow();
    private List<Client> clients;
    private List<Services> services;
    private List<Worker> workers;

    @FXML
    void initialize() {
       entityManagerFactory = Persistence.createEntityManagerFactory("MyPU");
        em = entityManagerFactory.createEntityManager();clientDAO = new ClientDAO(em);
        workerDAO = new WorkerDAO(em);
        serviceDAO = new ServiceDAO(em);

        setCellValueFactories();

        addClientRecordButton.setOnAction(event -> addClient());
        addServiceRecordButton.setOnAction(event -> addService());
        addWorkerRecordButton.setOnAction(event -> addWorker());
        showAllClientsButton.setOnAction(event -> showAllClients());
        showAllServicesButton.setOnAction(event -> showAllServices());
        showAllWorkersButton.setOnAction(event -> showAllWorkers());
        deleteClientSelectedRecordButton.setOnAction(event -> deleteClient());
        deleteSelectedServiceRecordButton.setOnAction(event -> deleteService());
        deleteSelectedWorkerRecordButton.setOnAction(event -> deleteWorker());
        editClientSelectedRecordButton.setOnAction(event -> editClient());
        editSelectedServiceRecordButton.setOnAction(event -> editService());
        editSelectedWorkerRecordButton.setOnAction(event -> editWorker());
        makeInvoiceShowServicesButton.setOnAction(event -> showServicesBriefInfo());
        addServiceToInvoiceButton.setOnAction(event -> addServiceToInvoice());
        makeInvoiceButton.setOnAction(event -> makeInvoice());
    }

    private void makeInvoice() {
        alertWindow.infoAlert("Накладная создана!");
    }

    private void addServiceToInvoice() {
        try {int i=>X509CertSelecto;

            Invoice invoice = servicesMakeInvoiceTable.getSelectionModel().getSelectedItem();
            List<Invoice> invoiceList = serviceInvoiceTable.getItems();
            invoiceList.add(invoice);
            serviceInvoiceTable.setItems(FXCollections.observableArrayList(invoiceList));
        } catch (Exception e) {
            alertWindow.errorAlert(e.getMessage());
        }
    }

    private void showServicesBriefInfo() {
        try {
            services = serviceDAO.findAll();
            List<Invoice> invoice = new ArrayList<>();
            for (Services service : services) {
                invoice.add(new Invoice(service.getServiceTitle(), service.getServicePrice()));
            }
            servicesMakeInvoiceTable.setItems(FXCollections.observableArrayList(invoice));
        } catch (Exception e) {
            alertWindow.errorAlert(e.getMessage());
        }
    }

    private void editWorker() {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        if (worker == null)
            return;

        Dialog<Services> dialog = new Dialog<>();
        var window = addClientRecordButton.getScene().getWindow();
        dialog.initOwner(window);
        dialog.setTitle("Управление СТО");
//ЕНапичатать выаод даггы  лпремнгглцй от y f
        ButtonType okButtonType = new ButtonType("Редактировать", ButtonType.OK.getButtonData());
        ButtonType cancelButtonType = new ButtonType("Отмена", ButtonType.CANCEL.getButtonData());
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, cancelButtonType);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));

        TextField secondName = new TextField(worker.getSecondName() );
        secondName.setPromptText("фамилия");
        TextField firstName = new TextField(worker.getFirstName());
        firstName.setPromptText("имя");
        TextField middleName = new TextField(worker.getMiddleName());
        middleName.setPromptText("отчество");
        TextField phone = new TextField(worker.getPhone() );
        phone.setPromptText("телефон");
        TextField hiringDate = new TextField(worker.getHiringDate().toString());
        hiringDate.setPromptText("дата принятия на работу");
        TextField salary = new TextField(Double.toString(worker.getSalary()));
        salary.setPromptText("зароботная плата");
        TextField occupation = new TextField(worker.getOccupation());
        occupation.setPromptText("род деятельности");

        grid.add(new Label("Фамилия"), 0, 0);
        grid.add(secondName, 1, 0);
        grid.add(new Label("Имя"), 0, 1);
        grid.add(firstName, 1, 1);
        grid.add(new Label("Отчество"), 0, 2);
        grid.add(middleName, 1, 2);
        grid.add(new Label("Контактный телефон"), 0, 3);
        grid.add(phone, 1, 3);
        grid.add(new Label("Дата принятия на работу"), 0, 4);
        grid.add(hiringDate, 1, 4);
        grid.add(new Label("Зароботная плата"), 0, 5);
        grid.add(salary, 1, 5);
        grid.add(new Label("Род деятельности"), 0, 6);
        grid.add(occupation, 1, 6);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {

            if (dialogButton == okButtonType) {
                try {
                    int indexSelected = workers.indexOf(worker);
                    worker.setSecondName(secondName.getText().trim());
                    worker.setFirstName(firstName.getText().trim());
                    worker.setMiddleName(middleName.getText().trim());
                    worker.setPhone(phone.getText().trim());
                    worker.setHiringDate(LocalDate.parse(hiringDate.getText().trim()));
                    worker.setSalary(Double.parseDouble(salary.getText().trim()));
                    worker.setOccupation(occupation.getText().trim());

                    workers.set(indexSelected, worker);
                    workerDAO.editRecord(worker);
                    workerTable.setItems(FXCollections.observableArrayList(workers));
                    workerTable.refresh();
                } catch (NullPointerException e) {
                    alertWindow.errorAlert("Ошибка! Введены неправильные данные!");
                } catch (NumberFormatException e) {
                    alertWindow.errorAlert("Ошибка! Введен текст вместо числа!");
                } catch (DateTimeParseException e) {
                    alertWindow.errorAlert("Ошибка! Введена некорректная дата!");
                }
            }
            return null;
        });
        Optional<Services> result = dialog.showAndWait();
    }

    private void editService() {
        Services service = servicesTable.getSelectionModel().getSelectedItem();
        if (service == null)
            return;

        Dialog<Services> dialog = new Dialog<>();
        var window = addClientRecordButton.getScene().getWindow();
        dialog.initOwner(window);
        dialog.setTitle("Управление СТО");

        ButtonType okButtonType = new ButtonType("Редактировать", ButtonType.OK.getButtonData());
        ButtonType cancelButtonType = new ButtonType("Отмена", ButtonType.CANCEL.getButtonData());
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, cancelButtonType);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));

        TextField serviceName = new TextField(service.getServiceTitle() );
        serviceName.setPromptText("название услуги");
        TextField serviceType = new TextField(service.getServiceType());
        serviceType.setPromptText("типа услуги");
        TextField servicePrice = new TextField(Double.toString(service.getServicePrice()));
        servicePrice.setPromptText("цена услуги");

        grid.add(new Label("Фамилия"), 0, 0);
        grid.add(serviceName, 1, 0);
        grid.add(new Label("Имя"), 0, 1);
        grid.add(serviceType, 1, 1);
        grid.add(new Label("Отчество"), 0, 2);
        grid.add(servicePrice, 1, 2);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {

            if (dialogButton == okButtonType) {
                try {
                    int indexSelected = services.indexOf(service);
                    service.setServiceTitle(serviceName.getText().trim());
                    service.setServiceType(serviceType.getText().trim());
                    service.setServicePrice(Double.parseDouble(servicePrice.getText().trim()));

                    services.set(indexSelected, service);
                    serviceDAO.editRecord(service);
                    servicesTable.setItems(FXCollections.observableArrayList(services));
                    servicesTable.refresh();
                } catch (NullPointerException e) {
                    alertWindow.errorAlert("Ошибка! Введены неправильные данные!");
                } catch (NumberFormatException e) {
                    alertWindow.errorAlert("Ошибка! Введен текст вместо числа!");
                }
            }
            return null;
        });
        Optional<Services> result = dialog.showAndWait();
    }

    private void editClient() {
        Client client = clientTable.getSelectionModel().getSelectedItem();
        if (client == null)
            return;

        Dialog<Client> dialog = new Dialog<>();
        var window = addClientRecordButton.getScene().getWindow();
        dialog.initOwner(window);
        dialog.setTitle("Управление СТО");

        ButtonType okButtonType = new ButtonType("Редактировать", ButtonType.OK.getButtonData());
        ButtonType cancelButtonType = new ButtonType("Отмена", ButtonType.CANCEL.getButtonData());
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, cancelButtonType);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));

        TextField secondName = new TextField(client.getSecondName() );
        secondName.setPromptText("фамилия");
        TextField firstName = new TextField(client.getFirstName());
        firstName.setPromptText("имя");
        TextField middleName = new TextField(client.getMiddleName());
        middleName.setPromptText("отчество");
        TextField phone = new TextField(client.getPhone());
        phone.setPromptText("контактный телефон");
        TextField dirversLicenceNum = new TextField(client.getDriverLicenseNum());
        dirversLicenceNum.setPromptText("номер водительского удостоверения");
        TextField carModel = new TextField(client.getCarModel());
        carModel.setPromptText("марка автомобиля");

        grid.add(new Label("Фамилия"), 0, 0);
        grid.add(secondName, 1, 0);
        grid.add(new Label("Имя"), 0, 1);
        grid.add(firstName, 1, 1);
        grid.add(new Label("Отчество"), 0, 2);
        grid.add(phone, 1, 2);
        grid.add(new Label("Контактный телефон"), 0, 3);
        grid.add(middleName, 1, 3);
        grid.add(new Label("Номер водительского удостоверения"), 0, 4);
        grid.add(dirversLicenceNum, 1, 4);
        grid.add(new Label("Марка автомобиля"), 0, 5);
        grid.add(carModel, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {

            if (dialogButton == okButtonType) {
                try {
                    int indexSelected = clients.indexOf(client);
                    client.setSecondName(secondName.getText().trim());
                    client.setFirstName(firstName.getText().trim());
                    client.setPhone(phone.getText().trim());
                    client.setMiddleName(middleName.getText().trim());
                    client.setDriverLicenseNum(dirversLicenceNum.getText().trim());
                    client.setCarModel(carModel.getText().trim());

                    clients.set(indexSelected, client);
                    clientDAO.editRecord(client);
                    clientTable.setItems(FXCollections.observableArrayList(clients));
                    clientTable.refresh();
                } catch (NullPointerException e) {
                    alertWindow.errorAlert("Ошибка! Введены неправильные данные!");
                } catch (NumberFormatException e) {
                    alertWindow.errorAlert("Ошибка! Введен текст вместо числа!");
                }
            }
            return null;
        });
        Optional<Client> result = dialog.showAndWait();
    }

    private void deleteWorker() {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        if (worker != null &&
                alertWindow.confirmationAlert("запись о работника", worker.briefInfo())) {
            workerDAO.delete(worker);
            workerTable.setItems(FXCollections.observableList(workerDAO.findAll()));
        }
    }

    private void deleteService() {
        Services service = servicesTable.getSelectionModel().getSelectedItem();
        if (service != null &&
                alertWindow.confirmationAlert("запись об услуге", service.briefInfo())) {
            serviceDAO.delete(service);
            servicesTable.setItems(FXCollections.observableList(serviceDAO.findAll()));
        }
    }

    private void deleteClient() {
        Client client = clientTable.getSelectionModel().getSelectedItem();
        if (client != null &&
                alertWindow.confirmationAlert("запись про клиента", client.briefInfo())) {
            clientDAO.delete(client);
            clientTable.setItems(FXCollections.observableList(clientDAO.findAll()));
        }
    }

    private void showAllWorkers() {
        try {
            workers = workerDAO.findAll();
            if (services.isEmpty()) {
                alertWindow.errorAlert("Записи не найдены!");
                return;
            }
            workerTable.getItems().clear();
            workerTable.setItems(FXCollections.observableList(workers));
        }
        catch (Exception ex) {
            alertWindow.errorAlert(ex.getMessage());
        }
    }

    private void showAllServices() {
        try {
            services = serviceDAO.findAll();
            if (services.isEmpty()) {
                alertWindow.errorAlert("Записи не найдены!");
                return;
            }
            servicesTable.getItems().clear();
            servicesTable.setItems(FXCollections.observableList(services));
        }
        catch (Exception ex) {
            alertWindow.errorAlert(ex.getMessage());
        }
    }

    private void showAllClients() {
        try {
            clients = clientDAO.findAll();
            if (clients.isEmpty()) {
                alertWindow.errorAlert("Записи не найдены!");
                return;
            }
            clientTable.getItems().clear();
            clientTable.setItems(FXCollections.observableList(clients));
        }
        catch (Exception ex) {
            alertWindow.errorAlert(ex.getMessage());
        }
    }

    private void addWorker() {
        if (firstNameWorkerTextField.getText().isEmpty() || secondNameWorkerTextField.getText().isEmpty() || middleNameWorkerTextField.getText().isEmpty()
                || phoneWorkerTextField.getText().isEmpty() || yyyyTextField.getText().isEmpty() || ddTextField.getText().isEmpty()
                || mmTextField.getText().isEmpty() || occupationWorkerTextField.getText().isEmpty() || salaryWorkerTextField.getText().isEmpty()) {
            alertWindow.errorAlert("Ошибка! Одно или несколько полей пусты!");
            return;
        }

        try {
            addWorkerResultLabel.setText("");
            Worker worker = new Worker();

            worker.setFirstName(firstNameWorkerTextField.getText().trim());
            worker.setSecondName(secondNameWorkerTextField.getText().trim());
            worker.setMiddleName(middleNameWorkerTextField.getText().trim());
            worker.setHiringDate(LocalDate.parse(yyyyTextField.getText().trim() + "-" + mmTextField.getText().trim() + "-" +
                    ddTextField.getText().trim()));
            worker.setPhone(phoneWorkerTextField.getText().trim());
            worker.setOccupation(occupationWorkerTextField.getText().trim());
            worker.setSalary(Double.parseDouble(salaryWorkerTextField.getText().trim()));

            workerDAO.add(worker);
            addWorkerResultLabel.setTextFill(Color.web("#00FF00"));
            addWorkerResultLabel.setText("Запись про услугу успешно добавлена!");

            if (!workerTable.getItems().isEmpty())
                workerTable.setItems(FXCollections.observableList(workerDAO.findAll()));

            firstNameWorkerTextField.clear();
            secondNameWorkerTextField.clear();
            middleNameWorkerTextField.clear();
            phoneWorkerTextField.clear();
            yyyyTextField.clear(); ddTextField.clear(); mmTextField.clear();
            occupationWorkerTextField.clear();
            salaryWorkerTextField.clear();

        } catch (NullPointerException e) {
            alertWindow.errorAlert("Ошибка! Введены неправильные данные!");
        } catch (NumberFormatException e) {
            alertWindow.errorAlert("Ошибка! Введен текст вместо числа!");
        } catch (DateTimeParseException e) {
            alertWindow.errorAlert("Ошибка! Введена некорректная дата!");
        }
    }

    private void addService() {
        if (serviceTitleTextField.getText().isEmpty() || serviceTypeTextField.getText().isEmpty() || servicePriceTextField.getText().isEmpty()) {
            alertWindow.errorAlert("Ошибка! Одно или несколько полей пусты!");
            return;
        }

        try {
            addServiceResultLabel.setText("");
            Services service = new Services();

            service.setServiceTitle(serviceTitleTextField.getText().trim());
            service.setServiceType(serviceTypeTextField.getText().trim());
            service.setServicePrice(Double.parseDouble(servicePriceTextField.getText().trim()));

            serviceDAO.add(service);
            addServiceResultLabel.setTextFill(Color.web("#00FF00"));
            addServiceResultLabel.setText("Запись про услугу успешно добавлена!");

            if (!servicesTable.getItems().isEmpty())
                servicesTable.setItems(FXCollections.observableList(serviceDAO.findAll()));

            serviceTypeTextField.clear();
            serviceTitleTextField.clear();
            servicePriceTextField.clear();
        } catch (NullPointerException e) {
            alertWindow.errorAlert("Ошибка! Введены неправильные данные!");
        } catch (NumberFormatException e) {
            alertWindow.errorAlert("Ошибка! Введен текст вместо числа!");
        }
    }

    private void addClient() {
        if(secondNameClientTextField.getText().isEmpty() || firstNameClientTextField.getText().isEmpty() || middleNameClientTextField.getText().isEmpty() ||
                phoneClientTextField.getText().isEmpty() || driversLicenceNumTextField.getText().isEmpty() || carModelClientTextField.getText().isEmpty()) {
            alertWindow.errorAlert("Ошибка! Одно или несколько полей пусты!");
            return;
        }

        try {
            addClientServiceLabel.setText("");
            Client client = new Client();

            client.setFirstName(firstNameClientTextField.getText().trim());
            client.setSecondName(secondNameClientTextField.getText().trim());
            client.setMiddleName(middleNameClientTextField.getText().trim());
            client.setPhone(phoneClientTextField.getText().trim());
            client.setDriverLicenseNum(driversLicenceNumTextField.getText().trim());
            client.setCarModel(carModelClientTextField.getText().trim());

            clientDAO.add(client);
            addClientServiceLabel.setTextFill(Color.web("#00FF00"));
            addClientServiceLabel.setText("Запись про клиента успешно добавлена!");

            if (!clientTable.getItems().isEmpty())
                clientTable.setItems(FXCollections.observableList(clientDAO.findAll()));

            firstNameClientTextField.clear();
            secondNameClientTextField.clear();
            middleNameClientTextField.clear();
            phoneClientTextField.clear();
            driversLicenceNumTextField.clear();
            carModelClientTextField.clear();
        } catch (NullPointerException e) {
            alertWindow.errorAlert("Ошибка! Введены неправильные данные!");
        }
    }

    private void setCellValueFactories() {
        makeInvoiceServiceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
        makeInvoiceServicePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        invoiceServiceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
        invoiceServicePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        idClientColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        secondNameClientColumn.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        firstNameClientColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameClientColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        phoneClientColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        driverLicenceClientColumn.setCellValueFactory(new PropertyValueFactory<>("driverLicenseNum"));
        carModelClientColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));

        idServiceColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        serviceTitleColumn.setCellValueFactory(new PropertyValueFactory<>("serviceTitle"));
        serviceTypeColumn.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        servicePriceColumn.setCellValueFactory(new PropertyValueFactory<>("servicePrice"));

        idWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        secondNameWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        phoneWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        hiringDateWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("hiringDate"));
        salaryWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        occupationWorkerColumn.setCellValueFactory(new PropertyValueFactory<>("occupation"));
    }
}
