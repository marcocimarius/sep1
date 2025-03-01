const projectsTableBody = $('#projectsTable').find("tbody");
let ongoingProjects = [];
function addProjectsToTable(){
    console.log(projectsTableBody);
    projectsTableBody.empty();
    ongoingProjects.forEach(project => {
        const row = $('<tr></tr>');
        const id = $('<td></td>').text(project.id);
        const name = $('<td></td>').text(project.name);
        const type = $('<td></td>').text(project.type);
        const timeline = $('<td></td>').text(project.timeline);
        const budget = $('<td></td>').text(project.budget);
        const customerName = $('<td></td>').text(project.customerName);
        const customerPhoneNumber = $('<td></td>').text(project.customerPhoneNumber);
        const customerEmail = $('<td></td>').text(project.customerEmail);
        const hoursUsed = $('<td></td>').text(project.hoursUsed);
        row.append(id);
        row.append(name);
        row.append(type);
        row.append(timeline);
        row.append(budget);
        row.append(customerName);
        row.append(customerPhoneNumber);
        row.append(customerEmail);
        row.append(hoursUsed);
        projectsTableBody.append(row);
    });
}

$(document).ready(()=>{
    $.ajax({
        url: 'resources/Projects.xml',
        type: 'GET',
        dataType: 'xml',
        success: (data)=>{
            console.log(data);
            const projectEls = $(data).find('project')
            ongoingProjects = projectEls.toArray().map(element => {

                const endDateDay = $(element).find('endDateDay').attr('value');
                const endDateMonth = $(element).find('endDateMonth').attr('value');
                const endDateYear = $(element).find('endDateYear').attr('value');
                if(endDateDay === "dnf" && endDateMonth === "dnf" && endDateYear === "dnf"){
                    const id = $(element).find('id').attr('value').split('-')[0];
                    let type = $(element).attr('type');
                    type = type.charAt(0).toUpperCase() + type.slice(1);
                    const name = $(element).find('name').attr('value');
                    const timeline = $(element).find('timeline').attr('value');
                    const budget = $(element).find('budget').attr('value');
                    const customerName = $(element).find('customerName').attr('value');
                    const customerPhoneNumber = $(element).find('customerPhoneNumber').attr('value');
                    const customerEmail = $(element).find('customerEmail').attr('value');
                    const hoursUsed= $(element).find('hoursUsed').attr('value');
                    
                    const project = {
                        id,
                        name,
                        type,
                        timeline,
                        budget,
                        customerName,
                        customerPhoneNumber,
                        customerEmail,
                        hoursUsed
                    }
                    return project;
                }
                return null; 
            }).filter(p => p !== null); 
        }
    }).then(() => {
        addProjectsToTable();
    });
    
});


