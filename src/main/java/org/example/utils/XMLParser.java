package org.example.utils;

import org.example.model.Customer;
import org.example.model.ProjectsList;
import org.example.model.Resources;
import org.example.model.project.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class is responsible for adding and reading the projects' information from the XML file.
 * @author Marius Marcoci
 */
public class XMLParser {
    /**
     * Writes all the projects' into an XML file with all the necessary nodes
     * @param doc contains all the nodes with all the information
     * @param filename the name of the XML File where the information will be stored
     * @throws TransformerException if the method encounters a transformerException
     */
    public static void writeXML(Document doc, String filename) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(filename);

        transformer.transform(source, result);
    }

    /**
     * Gets the type of the project
     * @param project the project whose type will be found
     * @return the type of the project
     */
    public static String getType(Project project) {
        String type = "";

        if (Project.isIndustrial(project)) {
            type = "industrial";
        } else if (Project.isCommercial(project)) {
            type = "commercial";
        } else if (Project.isResidential(project)) {
            type = "residential";
        } else if (Project.isRoadConstruction(project)) {
            type = "road";
        }

        return type;
    }

    /**
     * Generates the nodes for industrial projects
     * @param doc contains the common nodes of every project
     * @param project the industrial project which will be written into the nodes
     * @return the nodes with all the information of the industrial project
     */
    public static Element getIndustrialDetails(Document doc, Project project) {
        Element details = doc.createElement("details");
        IndustrialProject temp = (IndustrialProject) project;

        Element id = doc.createElement("id");
        id.setAttribute("value", project.getId().toString());
        details.appendChild(id);

        Element name = doc.createElement("name");
        name.setAttribute("value", project.getName());
        details.appendChild(name);

        Element timeline = doc.createElement("timeline");
        timeline.setAttribute("value", project.getTimeline());
        details.appendChild(timeline);

        Element budget = doc.createElement("budget");
        budget.setAttribute("value", Double.toString(project.getBudget()));
        details.appendChild(budget);

        Element size = doc.createElement("size");
        size.setAttribute("value", Double.toString(temp.getSize()));
        details.appendChild(size);

        Element typeOfIndustrialFacility = doc.createElement("typeOfIndustrialFacility");
        typeOfIndustrialFacility.setAttribute("value", temp.getTypeOfIndustrialFacility());
        details.appendChild(typeOfIndustrialFacility);

        return details;
    }

    /**
     * Generates the nodes for residential projects
     * @param doc contains the common nodes of every project
     * @param project the residential project which will be written into the nodes
     * @return the nodes with all the information of the residential project
     */
    public static Element getResidentialDetails(Document doc, Project project) {
        Element details = doc.createElement("details");
        ResidentialProject temp = (ResidentialProject) project;

        Element id = doc.createElement("id");
        id.setAttribute("value", project.getId().toString());
        details.appendChild(id);

        Element name = doc.createElement("name");
        name.setAttribute("value", project.getName());
        details.appendChild(name);

        Element timeline = doc.createElement("timeline");
        timeline.setAttribute("value", project.getTimeline());
        details.appendChild(timeline);

        Element budget = doc.createElement("budget");
        budget.setAttribute("value", Double.toString(project.getBudget()));
        details.appendChild(budget);

        Element size = doc.createElement("size");
        size.setAttribute("value", Double.toString(temp.getSize()));
        details.appendChild(size);

        Element numberOfKitchens = doc.createElement("numberOfKitchens");
        numberOfKitchens.setAttribute("value", Integer.toString(temp.getNumberOfKitchen()));
        details.appendChild(numberOfKitchens);

        Element numberOfBathrooms = doc.createElement("numberOfBathrooms");
        numberOfBathrooms.setAttribute("value", Integer.toString(temp.getNumberOfBathrooms()));
        details.appendChild(numberOfBathrooms);

        Element numberOfRoomsWithPlumbing = doc.createElement("numberOfRoomsWithPlumbing");
        numberOfRoomsWithPlumbing.setAttribute("value", Integer.toString(temp.getNumberOfRoomsWithPlumbing()));
        details.appendChild(numberOfRoomsWithPlumbing);

        Element isRenovated = doc.createElement("isRenovated");
        isRenovated.setAttribute("value", temp.isRenovated() ? "true" : "false");
        details.appendChild(isRenovated);

        return details;
    }

    /**
     * Generates the nodes for commercial projects
     * @param doc contains the common nodes of every project
     * @param project the commercial project which will be written into the nodes
     * @return the nodes with all the information of the commercial project
     */
    public static Element getCommercialDetails(Document doc, Project project) {
        Element details = doc.createElement("details");
        CommercialProject temp = (CommercialProject) project;

        Element id = doc.createElement("id");
        id.setAttribute("value", project.getId().toString());
        details.appendChild(id);

        Element name = doc.createElement("name");
        name.setAttribute("value", project.getName());
        details.appendChild(name);

        Element timeline = doc.createElement("timeline");
        timeline.setAttribute("value", project.getTimeline());
        details.appendChild(timeline);

        Element budget = doc.createElement("budget");
        budget.setAttribute("value", Double.toString(project.getBudget()));
        details.appendChild(budget);

        Element size = doc.createElement("size");
        size.setAttribute("value", Double.toString(temp.getSize()));
        details.appendChild(size);

        Element numberOfFloors = doc.createElement("numberOfFloors");
        numberOfFloors.setAttribute("value", Integer.toString(temp.getNumberOfFloors()));
        details.appendChild(numberOfFloors);

        Element intendedUseOfBuilding = doc.createElement("intendedUseOfBuilding");
        intendedUseOfBuilding.setAttribute("value", temp.getIntendedUseOfBuilding());
        details.appendChild(intendedUseOfBuilding);

        return details;
    }

    /**
     * Generates the nodes for road construction projects
     * @param doc contains the common nodes of every project
     * @param project the road construction project which will be written into the nodes
     * @return the nodes with all the information of the road construction project
     */
    public static Element getRoadDetails(Document doc, Project project) {
        Element details = doc.createElement("details");
        RoadConstructionProject temp = (RoadConstructionProject) project;

        Element id = doc.createElement("id");
        id.setAttribute("value", project.getId().toString());
        details.appendChild(id);

        Element name = doc.createElement("name");
        name.setAttribute("value", project.getName());
        details.appendChild(name);

        Element timeline = doc.createElement("timeline");
        timeline.setAttribute("value", project.getTimeline());
        details.appendChild(timeline);

        Element budget = doc.createElement("budget");
        budget.setAttribute("value", Double.toString(project.getBudget()));
        details.appendChild(budget);

        Element length = doc.createElement("length");
        length.setAttribute("value", Double.toString(temp.getLength()));
        details.appendChild(length);

        Element width = doc.createElement("width");
        width.setAttribute("value", Double.toString(temp.getWidth()));
        details.appendChild(width);

        Element numberOfBridges = doc.createElement("numberOfBridges");
        numberOfBridges.setAttribute("value", Integer.toString(temp.getNumberOfBridge()));
        details.appendChild(numberOfBridges);

        Element numberOfTunnels = doc.createElement("numberOfTunnels");
        numberOfTunnels.setAttribute("value", Integer.toString(temp.getNumberOfTunnels()));
        details.appendChild(numberOfTunnels);

        Element anyEnvironmentalOrGeographicalChallenges = doc.createElement("anyEnvironmentalOrGeographicalChallenges");
        anyEnvironmentalOrGeographicalChallenges.setAttribute("value", temp.getEnvOrGeoChallenges());
        details.appendChild(anyEnvironmentalOrGeographicalChallenges);

        return details;
    }

    /**
     * Calls the methods which insert the information of the project based on its type
     * @param doc contains the common nodes of every project
     * @param type the type of the project
     * @param project the project
     * @return the nodes with all the information of the road construction project
     */
    public static Element getDetails(Document doc, String type, Project project) {
        Element details = null;

        if (type.equals("industrial")) {
            details = getIndustrialDetails(doc, project);
        }
        else if (type.equals("commercial")) {
            details = getCommercialDetails(doc, project);
        } else if (type.equals("residential")) {
            details = getResidentialDetails(doc, project);
        }
        else {
            details = getRoadDetails(doc, project);
        }

        return details;
    }

    /**
     * Writes all the projects to the XML File
     * @param list the projects to be written
     * @throws ParserConfigurationException in case a parser configuration exception occurs
     * @throws TransformerException in case a transformer exception occurs
     */
    public static void writeProjectsToXML(ProjectsList list) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("projects");
        doc.appendChild(rootElement);

        for (int i = 0; i < list.getSize(); i++) {
            Element project = doc.createElement("project");
            String type = getType(list.getProject(i));
            project.setAttribute("type", type);

            Element customer = doc.createElement("customer");

            Element customerName = doc.createElement("customerName");
            customerName.setAttribute("value", list.getProject(i).getCustomer().getName());
            customer.appendChild(customerName);

            Element customerPhoneNumber = doc.createElement("customerPhoneNumber");
            customerPhoneNumber.setAttribute("value", list.getProject(i).getCustomer().getPhoneNumber());
            customer.appendChild(customerPhoneNumber);

            Element customerEmail = doc.createElement("customerEmail");
            customerEmail.setAttribute("value", list.getProject(i).getCustomer().getEmail());
            customer.appendChild(customerEmail);

            Element customerAddress = doc.createElement("customerAddress");
            customerAddress.setAttribute("value", list.getProject(i).getCustomer().getAddress());
            customer.appendChild(customerAddress);

            project.appendChild(customer);

            Element resources = doc.createElement("resources");

            Element hoursUsed = doc.createElement("hoursUsed");
            hoursUsed.setAttribute("value", Integer.toString(list.getProject(i).getResources().getHoursUsed()));
            resources.appendChild(hoursUsed);

            Element hoursNeeded = doc.createElement("hoursNeeded");
            hoursNeeded.setAttribute("value", Integer.toString(list.getProject(i).getResources().getHoursNeeded()));
            resources.appendChild(hoursNeeded);

            Element materialExpensesUsed = doc.createElement("materialExpensesUsed");
            materialExpensesUsed.setAttribute("value", Double.toString(list.getProject(i).getResources().getMaterialExpensedUsed()));
            resources.appendChild(materialExpensesUsed);

            Element materialExpensesNeeded = doc.createElement("materialExpensesNeeded");
            materialExpensesNeeded.setAttribute("value", Double.toString(list.getProject(i).getResources().getMaterialExpensedNeeded()));
            resources.appendChild(materialExpensesNeeded);

            project.appendChild(resources);

            Element startDate = doc.createElement("startDate");

            Element startDateDay = doc.createElement("startDateDay");
            startDateDay.setAttribute("value", Integer.toString(list.getProject(i).getStartDate().getDayOfMonth()));
            startDate.appendChild(startDateDay);

            Element startDateMonth = doc.createElement("startDateMonth");
            startDateMonth.setAttribute("value", Integer.toString(list.getProject(i).getStartDate().getMonthValue()));
            startDate.appendChild(startDateMonth);

            Element startDateYear = doc.createElement("startDateYear");
            startDateYear.setAttribute("value", Integer.toString(list.getProject(i).getStartDate().getYear()));
            startDate.appendChild(startDateYear);

            project.appendChild(startDate);

            Element expectedEndDate = doc.createElement("expectedEndDate");

            Element expectedEndDateDay = doc.createElement("expectedEndDateDay");
            expectedEndDateDay.setAttribute("value", Integer.toString(list.getProject(i).getExpectedEndDate().getDayOfMonth()));
            expectedEndDate.appendChild(expectedEndDateDay);

            Element expectedEndDateMonth = doc.createElement("expectedEndDateMonth");
            expectedEndDateMonth.setAttribute("value", Integer.toString(list.getProject(i).getExpectedEndDate().getMonthValue()));
            expectedEndDate.appendChild(expectedEndDateMonth);

            Element expectedEndDateYear = doc.createElement("expectedEndDateYear");
            expectedEndDateYear.setAttribute("value", Integer.toString(list.getProject(i).getExpectedEndDate().getYear()));
            expectedEndDate.appendChild(expectedEndDateYear);

            project.appendChild(expectedEndDate);

            Element endDate = doc.createElement("endDate");

            Element endDateDay = doc.createElement("endDateDay");
            endDateDay.setAttribute("value", (list.getProject(i).getEndDate() != null) ? Integer.toString(list.getProject(i).getEndDate().getDayOfMonth()) : "dnf");
            endDate.appendChild(endDateDay);

            Element endDateMonth = doc.createElement("endDateMonth");
            endDateMonth.setAttribute("value", (list.getProject(i).getEndDate() != null) ? Integer.toString(list.getProject(i).getEndDate().getMonthValue()) : "dnf");
            endDate.appendChild(endDateMonth);

            Element endDateYear = doc.createElement("endDateYear");
            endDateYear.setAttribute("value", (list.getProject(i).getEndDate() != null) ? Integer.toString(list.getProject(i).getEndDate().getYear()) : "dnf");
            endDate.appendChild(endDateYear);

            project.appendChild(endDate);


            Element details = getDetails(doc, type, list.getProject(i));
            project.appendChild(details);

            rootElement.appendChild(project);

            writeXML(doc, "sep1-website/resources/Projects.xml");
        }
    }

    /**
     * reads the projects from the XML File
     * @return an array list with all the projects
     */
    public static ArrayList<String> readXMLProjects() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        String string = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Get Document
            Document document = builder.parse(new File("sep1-website/resources/Projects.xml"));

            // Normalize the xml structure
            document.getDocumentElement().normalize();

            // Get all the element by the tag name
            NodeList projectList = document.getElementsByTagName("project");
            for(int i = 0; i <projectList.getLength(); i++) {
                Node project = projectList.item(i);
                Element projectType = (Element) project;
                string += (projectType.getAttribute("type") + ";");

                //in a single <project>
                if(project.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList projectDetails =  project.getChildNodes();

                    for(int j = 0; j < projectDetails.getLength(); j++){
                        Node detail = projectDetails.item(j);
                        //in a single detail ex: <customer>

                        if(detail.getNodeType() == Node.ELEMENT_NODE) {
                            NodeList detailList = detail.getChildNodes();

                            for (int k = 0; k < detailList.getLength(); k++) {
                                Node detail2 = detailList.item(k);

                                //getting elements from <customer>
                                if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                    Element detail2Element = (Element) detail2;
                                    string += (detail2Element.getAttribute("value") + ";");
                                }
                            }
                        }
                    }
                }
                stringArrayList.add(string);
                string = "";
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return stringArrayList;
    }

    /**
     * Inserts the already read projects into a ProjectsList object
     * @return the object with all the projects
     */
    public static ProjectsList getXMLArrayList() {
        ArrayList<String> arraysFromFile = readXMLProjects();
        ProjectsList list = new ProjectsList();
        String[] tempArr = null;

        for (int i = 0; i < arraysFromFile.size(); i++) {
            tempArr = arraysFromFile.get(i).split(";");

            LocalDate endDate = null;

            if (!tempArr[17].equals("dnf") && !tempArr[16].equals("dnf") && !tempArr[15].equals("dnf")) {
                endDate = LocalDate.of(Integer.parseInt(tempArr[17]), Integer.parseInt(tempArr[16]), Integer.parseInt(tempArr[15]));
            }

            if (tempArr[0].equals("industrial")) {
                list.addProject(new IndustrialProject(
                        //customer
                        new Customer(tempArr[1], tempArr[2], tempArr[3], tempArr[4]),
                        //resources
                        new Resources(Integer.parseInt(tempArr[5]), Integer.parseInt(tempArr[6]), Double.parseDouble(tempArr[7]), Double.parseDouble(tempArr[8])),
                        //startDate
                        LocalDate.of(Integer.parseInt(tempArr[11]), Integer.parseInt(tempArr[10]), Integer.parseInt(tempArr[9])),
                        //expectedEndDate
                        LocalDate.of(Integer.parseInt(tempArr[14]), Integer.parseInt(tempArr[13]), Integer.parseInt(tempArr[12])),
                        //endDate
                        endDate,
                        //id
                        UUID.fromString(tempArr[18]),
                        //name
                        tempArr[19],
                        //timeline
                        tempArr[20],
                        //budget
                        Double.parseDouble(tempArr[21]),
                        //size
                        Double.parseDouble(tempArr[22]),
                        //typeOfIndustrialFacility
                        tempArr[23]
                ));
            }
            else if (tempArr[0].equals("residential")) {
                list.addProject(new ResidentialProject(
                        //customer
                        new Customer(tempArr[1], tempArr[2], tempArr[3], tempArr[4]),
                        //resources
                        new Resources(Integer.parseInt(tempArr[5]), Integer.parseInt(tempArr[6]), Double.parseDouble(tempArr[7]), Double.parseDouble(tempArr[8])),
                        //startDate
                        LocalDate.of(Integer.parseInt(tempArr[11]), Integer.parseInt(tempArr[10]), Integer.parseInt(tempArr[9])),
                        //expectedEndDate
                        LocalDate.of(Integer.parseInt(tempArr[14]), Integer.parseInt(tempArr[13]), Integer.parseInt(tempArr[12])),
                        //endDate
                        endDate,
                        //id
                        UUID.fromString(tempArr[18]),
                        //name
                        tempArr[19],
                        //timeline
                        tempArr[20],
                        //budget
                        Double.parseDouble(tempArr[21]),
                        //size
                        Double.parseDouble(tempArr[22]),
                        //numberOfKitchens
                        Integer.parseInt(tempArr[23]),
                        //numberOfBathrooms
                        Integer.parseInt(tempArr[24]),
                        //numberOfRoomsWithPlumbing
                        Integer.parseInt(tempArr[25]),
                        //isRenovated
                        tempArr[26].equals("true")
                ));
            }
            else if (tempArr[0].equals("commercial")) {
                list.addProject(new CommercialProject(
                        //customer
                        new Customer(tempArr[1], tempArr[2], tempArr[3], tempArr[4]),
                        //resources
                        new Resources(Integer.parseInt(tempArr[5]), Integer.parseInt(tempArr[6]), Double.parseDouble(tempArr[7]), Double.parseDouble(tempArr[8])),
                        //startDate
                        LocalDate.of(Integer.parseInt(tempArr[11]), Integer.parseInt(tempArr[10]), Integer.parseInt(tempArr[9])),
                        //expectedEndDate
                        LocalDate.of(Integer.parseInt(tempArr[14]), Integer.parseInt(tempArr[13]), Integer.parseInt(tempArr[12])),
                        //endDate
                        endDate,
                        //id
                        UUID.fromString(tempArr[18]),
                        //name
                        tempArr[19],
                        //timeline
                        tempArr[20],
                        //budget
                        Double.parseDouble(tempArr[21]),
                        //size
                        Double.parseDouble(tempArr[22]),
                        //numberOfFloors
                        Integer.parseInt(tempArr[23]),
                        //intendedUseOfBuilding
                        tempArr[24]
                ));
            }
            else {
                list.addProject(new RoadConstructionProject(
                        //customer
                        new Customer(tempArr[1], tempArr[2], tempArr[3], tempArr[4]),
                        //resources
                        new Resources(Integer.parseInt(tempArr[5]), Integer.parseInt(tempArr[6]), Double.parseDouble(tempArr[7]), Double.parseDouble(tempArr[8])),
                        //startDate
                        LocalDate.of(Integer.parseInt(tempArr[11]), Integer.parseInt(tempArr[10]), Integer.parseInt(tempArr[9])),
                        //expectedEndDate
                        LocalDate.of(Integer.parseInt(tempArr[14]), Integer.parseInt(tempArr[13]), Integer.parseInt(tempArr[12])),
                        //endDate
                        endDate,
                        //id
                        UUID.fromString(tempArr[18]),
                        //name
                        tempArr[19],
                        //timeline
                        tempArr[20],
                        //budget
                        Double.parseDouble(tempArr[21]),
                        //length
                        Double.parseDouble(tempArr[22]),
                        //width
                        Double.parseDouble(tempArr[23]),
                        //numberOfBridges
                        Integer.parseInt(tempArr[24]),
                        //numberOfTunnels
                        Integer.parseInt(tempArr[25]),
                        //anyEnvironmentalChallenges
                        tempArr[26]
                ));
            }
        }

        return list;
    }
}