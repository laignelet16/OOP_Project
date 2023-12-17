-- author name: Julissa Laignelet
-- model: broadway

create schema if not exists broadwayshow1; 

use broadwayshow1; 

/* Table: broadway2 */
CREATE TABLE broadway2 (    
  id             INT AUTO_INCREMENT,
  show_name      VARCHAR(50),
  show_time      VARCHAR(50),
  show_date      VARCHAR(50), 
  show_description VARCHAR(250),
  PRIMARY KEY (id)
);

insert into broadway2 (id, show_name, show_time, show_date, show_description) values 
  (1, 'Wicked', '4:00 PM', 'October 14, 2025','Wicked is a broadway show about the witches in Wizard of Oz because they too need a voice.'),
  (2,'Moulin Rouge! The Musical', '5:00 PM', 'October 20, 2025', 'Moulin Rouge is centered around a poet in the 1890s falling in love Moulin Rouge nightclub.'),
  (3,'Chicago', '6:00 PM', 'October 10, 2025', 'Chicago takes place in the roaring 20s, where the story unfolds about two murderesses locked in jail.'),
  (4,'The Lion King', '7:00 PM', 'October 7, 2025', 'The Lion King musical is about the young lion prince, Simba, and his hardships in becoming king.'),
  (5,'The Notebook', '4:00 PM', 'October 18, 2025', 'The Notebook is about two lovers from different worlds share a heartfelt love despite forces pushing them apart.')