-- author name: Julissa Laignelet
-- model: broadway

create schema if not exists broadwayshow; 

use broadwayshow; 

/* Table: broadway */
CREATE TABLE broadway (    
  id             INT AUTO_INCREMENT,
  show_name      VARCHAR(50),
  show_time      VARCHAR(50),
  show_date      VARCHAR(50), 
  PRIMARY KEY (id)
);