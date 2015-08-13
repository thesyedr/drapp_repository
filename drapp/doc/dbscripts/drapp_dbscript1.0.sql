--patient table
create table patient(patientId int(5) not null AUTO_INCREMENT,patientName varchar(50) not null, PRIMARY KEY(patientId));
-- contacts table
create table contacts(contactId int(5) AUTO_INCREMENT,emailId varchar(30),
homePhone int(12),mobilePhone int(12),
patientCaregiver varchar(25),street varchar(25),state varchar(25),city varchar(25),
zip varchar(25),contactType varchar(25), PRIMARY KEY (contactId))

--adding the foreign key of contactid to patient table
alter table patient add contactId int(5);
alter table patient add CONSTRAINT FOREIGN KEY(contactId) REFERENCES contacts(contactId)

--insurance table
create table insurance (insuranceId int(5),dateofBirth varchar(15),insuranceProvider varchar(20),
	insuranceNumber int(5),insuranceGroup varchar(10),employerName varchar(20),employerAddress varchar(30),
	PRIMARY KEY (insuranceId))
-- adding the foregin key of insurance to patient table 
alter table patient add insuranceId int(5)
alter table patient add CONSTRAINT FOREIGN KEY (insuranceId) REFERENCES insurance(insuranceId)

--adding the auto-increment to insuranceId,as in the above it was missed
alter table patient drop FOREIGN KEY patient_ibfk_2
ALTER TABLE insurance CHANGE insuranceId insuranceId INT(5) AUTO_INCREMENT;
alter table patient add CONSTRAINT FOREIGN KEY (insuranceId) REFERENCES insurance(insuranceId)

--dropping the foreign key from patient table
alter table patient drop FOREIGN KEY patient_ibfk_1;
alter table patient drop FOREIGN KEY patient_ibfk_2;

--dropping the contactId and insuranceId columns
alter table patient drop column contactId;
alter table patient drop column insuranceId;

--creating the foreign key columns as patientId in contact and insurance table
alter table contacts add column patientId int(5) ;
alter table contacts add CONSTRAINT FOREIGN KEY (patientId) REFERENCES patient(patientId)

alter table insurance add column patientId int(5) ;
alter table insurance add CONSTRAINT FOREIGN KEY (patientId) REFERENCES patient(patientId)