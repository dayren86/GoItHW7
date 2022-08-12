INSERT INTO developers(name, age, sex, salary) VALUES
('Andrey', 25, 'MALE', 3000),
('Bogdan', 30, 'MALE', 2000),
('Denis', 35, 'MALE', 5000),
('Tanya', 30, 'FEMALE', 6000),
('Olya', 40, 'FEMALE', 3500),
('Ira', 50, 'FEMALE', 3400);

INSERT INTO skills (positions, skill_level) VALUES
('JAVA', 'SENIOR'),
('JAVA', 'MIDDLE'),
('JAVA', 'JUNIOR'),
('CSHARP', 'SENIOR'),
('CSHARP', 'MIDDLE'),
('CSHARP', 'JUNIOR'),
('JS', 'SENIOR'),
('JS', 'MIDDLE'),
('JS', 'JUNIOR'),
('CPLUS', 'SENIOR'),
('CPLUS', 'MIDDLE'),
('CPLUS', 'JUNIOR');

INSERT INTO projects (project_name, project_description, date_creation) VALUES
('Сhat bot','Creation and support of chat bots', '2005-05-25'),
('Sites', 'Website development', '2015-11-5'),
('Database', 'Creation and support of Database', '2020-7-24');

INSERT INTO companies(it_companies,company_description) VALUES
('Gamedev', 'Games development'),
('WebDev','Website development'),
('Mobile','Mobile development');

INSERT INTO developers_skills (developers_id, skills_id) VALUES
(2,3),
(1,2),
(4,5),
(3,8),
(5,8),
(6,4);

INSERT INTO developers_projects(developers_id, projects_id) VALUES
(1,1),
(2,1),
(3,2),
(4,2),
(5,3),
(6,3);