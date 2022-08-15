create
database organizationOfEvents;

-- Table StatusEventVSTU
CREATE TABLE StatusEventVSTU
(
    Id_StatusEventVSTU      INT         NOT NULL AUTO_INCREMENT,
    Name_of_StatusEventVSTU Varchar(50) NOT NULL,
    PRIMARY KEY (Id_StatusEventVSTU)
);

-- Table Roles
CREATE TABLE Roles
(
    Id_role   INT          NOT NULL AUTO_INCREMENT,
    Name_role Varchar(100) NOT NULL,
    PRIMARY KEY (Id_role)
);

-- Table Curriculum
CREATE TABLE Curriculum
(
    Id_curriculum      INT          NOT NULL AUTO_INCREMENT,
    Direction          Varchar(255) NOT NULL,
    Course             Bigint       NOT NULL,
    Profile_curriculum Varchar(255) NOT NULL,
    PRIMARY KEY (Id_curriculum)
);


-- Table Faculties
CREATE TABLE Faculties
(
    Id_faculty INT         NOT NULL AUTO_INCREMENT,
    Faculty    Varchar(30) NOT NULL,
    PRIMARY KEY (Id_faculty)
);

-- Table Student
CREATE TABLE Student
(
    Id_student       INT          NOT NULL AUTO_INCREMENT,
    Surname          Varchar(255) NOT NULL,
    Name_student     Varchar(255) NOT NULL,
    Middle_name      Varchar(255),
    email            Varchar(255) NOT NULL,
    Login            Varchar(255) NOT NULL,
    Password_student Varchar(255) NOT NULL,
    PRIMARY KEY (Id_student)
);

-- Table Participants
CREATE TABLE Participants
(
    Id_type_participant INT         NOT NULL AUTO_INCREMENT,
    Type_of_participant Varchar(50) NOT NULL,
    PRIMARY KEY (Id_type_participant)
);

-- Table EventVSTU
CREATE TABLE EventVSTU
(
    Id_EventVSTU          INT          NOT NULL AUTO_INCREMENT,
    EventVSTU_name        Varchar(255) NOT NULL,
    EventVSTU_description TEXT,
    Begin_of_EventVSTU    Date         NOT NULL,
    End_of_EventVSTU      Date         NOT NULL,
    Venue                 Varchar(255) NOT NULL,
    Organizer             Varchar(255) NOT NULL,
    Speaker               Varchar(255) NOT NULL,
    Id_StatusEventVSTU    INT          NOT NULL,
    PRIMARY KEY (Id_EventVSTU),
    FOREIGN KEY (Id_StatusEventVSTU) REFERENCES StatusEventVSTU (Id_StatusEventVSTU) ON DELETE CASCADE
);

CREATE TABLE Reviews
(
    Id_review    INT    NOT NULL AUTO_INCREMENT,
    Reviews      TEXT,
    Rate         Bigint NOT NULL,
    Id_EventVSTU INT    NOT NULL,
    PRIMARY KEY (Id_review),
    FOREIGN KEY (Id_EventVSTU) REFERENCES EventVSTU (Id_EventVSTU) ON DELETE CASCADE
);

-- Table Department
CREATE TABLE Department
(
    Id_department      INT          NOT NULL AUTO_INCREMENT,
    Name_of_department Varchar(255) NOT NULL,
    Id_faculty         INT          NOT NULL,
    PRIMARY KEY (Id_department),
    FOREIGN KEY (Id_faculty) REFERENCES Faculties (Id_faculty) ON DELETE CASCADE
);

-- Table GroupsVSTU
CREATE TABLE GroupsVSTU
(
    Id_group   INT          NOT NULL AUTO_INCREMENT,
    GroupVSTU  Varchar(255) NOT NULL,
    Id_faculty INT          NOT NULL,
    PRIMARY KEY (Id_group),
    FOREIGN KEY (Id_faculty) REFERENCES Faculties (Id_faculty) ON DELETE CASCADE
);

-- Table Tags
CREATE TABLE Tags
(
    Id_tag              INT          NOT NULL AUTO_INCREMENT,
    Tag                 Varchar(255) NOT NULL,
    Id_type_participant INT          NOT NULL,
    PRIMARY KEY (Id_tag),
    FOREIGN KEY (Id_type_participant) REFERENCES Participants (Id_type_participant) ON DELETE CASCADE
);

-- Table Department_tags
CREATE TABLE Department_tags
(
    Id_department_tag INT NOT NULL AUTO_INCREMENT,
    Id_tag            INT NOT NULL,
    Id_department     INT NOT NULL,
    PRIMARY KEY (Id_department_tag),
    FOREIGN KEY (Id_tag) REFERENCES Tags (Id_tag) ON DELETE CASCADE,
    FOREIGN KEY (Id_department) REFERENCES Department (Id_department) ON DELETE CASCADE
);

-- Table Group_tags
CREATE TABLE Group_tags
(
    Id_tag_GroupsVSTU INT NOT NULL AUTO_INCREMENT,
    Id_tag            INT NOT NULL,
    Id_group          INT NOT NULL,
    PRIMARY KEY (Id_tag_GroupsVSTU),
    FOREIGN KEY (Id_tag) REFERENCES Tags (Id_tag) ON DELETE CASCADE,
    FOREIGN KEY (Id_group) REFERENCES GroupsVSTU (Id_group) ON DELETE CASCADE
);

-- Table Student_group
CREATE TABLE Students_curriculum
(
    Id_students_curriculum INT NOT NULL AUTO_INCREMENT,
    Id_student             INT NOT NULL,
    Id_curriculum          INT NOT NULL,
    PRIMARY KEY (Id_students_curriculum),
    FOREIGN KEY (Id_student) REFERENCES Student (Id_student) ON DELETE CASCADE,
    FOREIGN KEY (Id_curriculum) REFERENCES Curriculum (Id_curriculum) ON DELETE CASCADE
);

-- Table Student_group
CREATE TABLE Student_group
(
    Id_student_group INT NOT NULL AUTO_INCREMENT,
    Id_student       INT NOT NULL,
    Id_group         INT NOT NULL,
    Id_faculty       INT NOT NULL,
    PRIMARY KEY (Id_student_group),
    FOREIGN KEY (Id_student) REFERENCES Student (Id_student) ON DELETE CASCADE,
    FOREIGN KEY (Id_group) REFERENCES GroupsVSTU (Id_group) ON DELETE CASCADE
);

-- Table Employee
CREATE TABLE Employee
(
    Id_employee       INT          NOT NULL AUTO_INCREMENT,
    Surname           Varchar(255) NOT NULL,
    Name_employee     Varchar(255) NOT NULL,
    Middle_name       Varchar(255),
    e_mail            Varchar(255) NOT NULL,
    Login             Varchar(255) NOT NULL,
    Password_employee Varchar(255) NOT NULL,
    Id_role           INT          NOT NULL,
    Id_faculty        INT          NOT NULL,
    Id_department     INT          NOT NULL,
    PRIMARY KEY (Id_employee),
    FOREIGN KEY (Id_role) REFERENCES Roles (Id_role) ON DELETE CASCADE,
    FOREIGN KEY (Id_department) REFERENCES Department (Id_department) ON DELETE CASCADE
);

-- Table EventVSTU_tags
CREATE TABLE EventVSTU_tags
(
    Id_EventVSTU_tags INT NOT NULL AUTO_INCREMENT,
    Id_tag            INT NOT NULL,
    Id_EventVSTU      INT NOT NULL,
    PRIMARY KEY (Id_EventVSTU_tags),
    FOREIGN KEY (Id_tag) REFERENCES Tags (Id_tag) ON DELETE CASCADE,
    FOREIGN KEY (Id_EventVSTU) REFERENCES EventVSTU (Id_EventVSTU) ON DELETE CASCADE
);

-- Table Employee_at_EventVSTU
CREATE TABLE Employee_at_EventVSTU
(
    Id_employee_at_EventVSTU INT NOT NULL AUTO_INCREMENT,
    Id_EventVSTU             INT NOT NULL,
    Id_employee              INT NOT NULL,
    PRIMARY KEY (Id_employee_at_EventVSTU),
    FOREIGN KEY (Id_EventVSTU) REFERENCES EventVSTU (Id_EventVSTU) ON DELETE CASCADE,
    FOREIGN KEY (Id_employee) REFERENCES Employee (Id_employee) ON DELETE CASCADE
);

-- Table Student_at_EventVSTU
CREATE TABLE Student_at_EventVSTU
(
    Id_student_at_EventVSTU INT NOT NULL AUTO_INCREMENT,
    Id_EventVSTU            INT NOT NULL,
    Id_student              INT NOT NULL,
    PRIMARY KEY (Id_student_at_EventVSTU),
    FOREIGN KEY (Id_EventVSTU) REFERENCES EventVSTU (Id_EventVSTU) ON DELETE CASCADE,
    FOREIGN KEY (Id_student) REFERENCES Student (Id_student) ON DELETE CASCADE
);


