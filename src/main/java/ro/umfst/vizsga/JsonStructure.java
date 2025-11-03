/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.vizsga;
import java.util.List;
/**
 *
 * @author Laptop
 */
public class JsonStructure {

    private List<Intake> intakes;

    public JsonStructure() {} 

    public JsonStructure(List<Intake> intakes) {
        this.intakes = intakes;
    }

    public List<Intake> getIntakes() { return intakes; }
    public void setIntakes(List<Intake> intakes) { this.intakes = intakes; }

    public static class Intake {

        private String intakeId;
        private String receivedAt;
        private Client client;
        private Car car;
        private List<ReportedIssue> reportedIssues;
        private Diagnostics diagnostics;
        private List<WorkOrder> workOrders;
        private Invoice invoice;
        private Meta meta;

        public Intake() {}

        public Intake(String intakeId, String receivedAt, Client client, Car car,
                      List<ReportedIssue> reportedIssues, Diagnostics diagnostics,
                      List<WorkOrder> workOrders, Invoice invoice, Meta meta) {
            this.intakeId = intakeId;
            this.receivedAt = receivedAt;
            this.client = client;
            this.car = car;
            this.reportedIssues = reportedIssues;
            this.diagnostics = diagnostics;
            this.workOrders = workOrders;
            this.invoice = invoice;
            this.meta = meta;
        }

        public String getIntakeId() { return intakeId; }
        public void setIntakeId(String intakeId) { this.intakeId = intakeId; }

        public String getReceivedAt() { return receivedAt; }
        public void setReceivedAt(String receivedAt) { this.receivedAt = receivedAt; }

        public Client getClient() { return client; }
        public void setClient(Client client) { this.client = client; }

        public Car getCar() { return car; }
        public void setCar(Car car) { this.car = car; }

        public List<ReportedIssue> getReportedIssues() { return reportedIssues; }
        public void setReportedIssues(List<ReportedIssue> reportedIssues) { this.reportedIssues = reportedIssues; }

        public Diagnostics getDiagnostics() { return diagnostics; }
        public void setDiagnostics(Diagnostics diagnostics) { this.diagnostics = diagnostics; }

        public List<WorkOrder> getWorkOrders() { return workOrders; }
        public void setWorkOrders(List<WorkOrder> workOrders) { this.workOrders = workOrders; }

        public Invoice getInvoice() { return invoice; }
        public void setInvoice(Invoice invoice) { this.invoice = invoice; }

        public Meta getMeta() { return meta; }
        public void setMeta(Meta meta) { this.meta = meta; }

        

        public static class Client extends BaseEntity{
            private String id;
            private String name;
            private String phone;
            private String email;

            public Client() {}
            public Client(String id, String name, String phone, String email) {
                this.id = id; this.name = name; this.phone = phone; this.email = email;
            }
            public String getId() { return id; }
            public void setId(String id) { this.id = id; }
            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
            public String getPhone() { return phone; }
            public void setPhone(String phone) { this.phone = phone; }
            public String getEmail() { return email; }
            public void setEmail(String email) { this.email = email; }
            
            @Override
               public String businessKey() {
                   return id; 
               } 
        }

        public static class Car {
            private String vin;
            private String make;
            private String model;
            private int year;
            private int odometerKm;
            private boolean warrantyActive;

            public Car() {}
            public Car(String vin, String make, String model, int year, int odometerKm, boolean warrantyActive) {
                this.vin = vin; this.make = make; this.model = model;
                this.year = year; this.odometerKm = odometerKm; this.warrantyActive = warrantyActive;
            }
            public String getVin() { return vin; }
            public void setVin(String vin) { this.vin = vin; }
            public String getMake() { return make; }
            public void setMake(String make) { this.make = make; }
            public String getModel() { return model; }
            public void setModel(String model) { this.model = model; }
            public int getYear() { return year; }
            public void setYear(int year) { this.year = year; }
            public int getOdometerKm() { return odometerKm; }
            public void setOdometerKm(int odometerKm) { this.odometerKm = odometerKm; }
            public boolean isWarrantyActive() { return warrantyActive; }
            public void setWarrantyActive(boolean warrantyActive) { this.warrantyActive = warrantyActive; }
        }

        public static class ReportedIssue {
            private String severity;
            private String code;
            private List<String> symptoms;
            private int sinceKm;

            public ReportedIssue() {}
            public ReportedIssue(String severity, String code, List<String> symptoms, int sinceKm) {
                this.severity = severity; this.code = code; this.symptoms = symptoms; this.sinceKm = sinceKm;
            }
            public String getSeverity() { return severity; }
            public void setSeverity(String severity) { this.severity = severity; }
            public String getCode() { return code; }
            public void setCode(String code) { this.code = code; }
            public List<String> getSymptoms() { return symptoms; }
            public void setSymptoms(List<String> symptoms) { this.symptoms = symptoms; }
            public int getSinceKm() { return sinceKm; }
            public void setSinceKm(int sinceKm) { this.sinceKm = sinceKm; }
        }

        public static class Diagnostics {
            private List<OBD> obd;
            private List<Test> tests;

            public Diagnostics() {}
            public Diagnostics(List<OBD> obd, List<Test> tests) { this.obd = obd; this.tests = tests; }

            public List<OBD> getObd() { return obd; }
            public void setObd(List<OBD> obd) { this.obd = obd; }
            public List<Test> getTests() { return tests; }
            public void setTests(List<Test> tests) { this.tests = tests; }

            public static class OBD {
                private String dtc;
                private String status;

                public OBD() {}
                public OBD(String dtc, String status) { this.dtc = dtc; this.status = status; }
                public String getDtc() { return dtc; }
                public void setDtc(String dtc) { this.dtc = dtc; }
                public String getStatus() { return status; }
                public void setStatus(String status) { this.status = status; }
            }

            public static class Test {
                private String name;
                private boolean ok;

                public Test() {}
                public Test(String name, boolean ok) { this.name = name; this.ok = ok; }
                public String getName() { return name; }
                public void setName(String name) { this.name = name; }
                public boolean isOk() { return ok; }
                public void setOk(boolean ok) { this.ok = ok; }
            }
        }

        public static class WorkOrder {
            private String type;
            private List<Task> tasks;
            private List<Part> parts;

            public WorkOrder() {}
            public WorkOrder(String type, List<Task> tasks, List<Part> parts) {
                this.type = type; this.tasks = tasks; this.parts = parts;
            }

            public String getType() { return type; }
            public void setType(String type) { this.type = type; }
            public List<Task> getTasks() { return tasks; }
            public void setTasks(List<Task> tasks) { this.tasks = tasks; }
            public List<Part> getParts() { return parts; }
            public void setParts(List<Part> parts) { this.parts = parts; }
            public void computLabor(){
            
            if(getType() == "MECHANICAL"){
                
            }
            
            if(getType() == "ELECTRICAL"){
            }
            }
            
            public static class Task {
                private String id;
                private String desc;
                private double laborH;
                private double hourly;

                public Task() {}
                public Task(String id, String desc, double laborH, double hourly) {
                    this.id = id; this.desc = desc; this.laborH = laborH; this.hourly = hourly;
                }

                public String getId() { return id; }
                public void setId(String id) { this.id = id; }
                public String getDesc() { return desc; }
                public void setDesc(String desc) { this.desc = desc; }
                public double getLaborH() { return laborH; }
                public void setLaborH(double laborH) { this.laborH = laborH; }
                public double getHourly() { return hourly; }
                public void setHourly(double hourly) { this.hourly = hourly; }
            }

            public static class Part {
                private String sku;
                private String name;
                private int qty;
                private double unitPrice;

                public Part() {}
                public Part(String sku, String name, int qty, double unitPrice) {
                    this.sku = sku; this.name = name; this.qty = qty; this.unitPrice = unitPrice;
                }

                public String getSku() { return sku; }
                public void setSku(String sku) { this.sku = sku;}
                public String getName() { return name; }
                public void setName(String name) { this.name = name; }
                public int getQty() { return qty; }
                public void setQty(int qty) { this.qty = qty; }
                public double getUnitPrice() { return unitPrice; }
                public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
            }
        }

        public static class Invoice {
            private String currency;
            private boolean paid;

            public Invoice() {}
            public Invoice(String currency, boolean paid) {
                this.currency = currency;
                this.paid = paid;
            }

            public String getCurrency() { return currency; }
            public void setCurrency(String currency) { this.currency = currency; }
            public boolean isPaid() { return paid; }
            public void setPaid(boolean paid) { this.paid = paid; }
        }

        public static class Meta {
            private String priority;
            private boolean courtesyCar;

            public Meta() {}
            public Meta(String priority, boolean courtesyCar) {
                this.priority = priority;
                this.courtesyCar = courtesyCar;
            }

            public String getPriority() { return priority; }
            public void setPriority(String priority) { this.priority = priority; }
            public boolean isCourtesyCar() { return courtesyCar; }
            public void setCourtesyCar(boolean courtesyCar) { this.courtesyCar = courtesyCar; }
        }

    } 
} 
