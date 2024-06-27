USE proyecto_plantquest;
ALTER TABLE Answer MODIFY COLUMN question BIGINT NULL;

INSERT INTO question (text, property) VALUES
                                          ('How many hours of natural light do you get in your home?', 'lightHours'),
                                          ('What type of light do you receive at home?', 'lightType'),
                                          ('What is the direction of your windows?', 'lightOrientation'),
                                          ('How much space do you have for your plants?', 'size'),
                                          ('How would you like to display your plant at home?', 'exhibit'),
                                          ('How much humidity is there normally in this place?', 'humidity'),
                                          ('And the average temperature?', 'temperature'),
                                          ('Do you have pets or children that may interact with the plants?', 'toxicity'),
                                          ('How often could you water it?', 'watering'),
                                          ('What type of plant do you prefer?', 'type');


INSERT INTO Answer (text, question, property_value) VALUES
                                                        ('Less than 3 hours', 1, 1),
                                                        ('From 3 to 6 hours', 1, 2),
                                                        ('From 6 to 9 hours', 1, 3),
                                                        ('More than 9 hours', 1, 4),
                                                        ('Low', 2, 1),
                                                        ('Indirect or filtered', 2, 2),
                                                        ('Bright', 2, 3),
                                                        ('Direct', 2, 4),
                                                        ('North', 3, 1),
                                                        ('South', 3, 2),
                                                        ('East', 3, 3),
                                                        ('West', 3, 4),
                                                        ('Small', 4, 1),
                                                        ('Medium', 4, 2),
                                                        ('Large', 4, 3),
                                                        ('On the table', 5, 1),
                                                        ('On the floor', 5, 2),
                                                        ('Hanging', 5, 3),
                                                        ('Very little (less than 35%)', 6, 1),
                                                        ('Moderate (around 45%)', 6, 2),
                                                        ('A lot (more than 50%)', 6, 3),
                                                        ('Less than 20º', 7, 1),
                                                        ('From 20º to 25º', 7, 2),
                                                        ('From 25º to 30º', 7, 3),
                                                        ('More than 30º', 7, 4),
                                                        ('I have pets', 8, 1),
                                                        ('I have children', 8, 2),
                                                        ('Both', 8, 3),
                                                        ('Neither', 8, 4),
                                                        ('Once a week', 9, 1),
                                                        ('Every two weeks', 9, 2),
                                                        ('Once a month or less', 9, 3),
                                                        ('Green leafy plants', 10, 1),
                                                        ('Flowering plants', 10, 2),
                                                        ('Cacti and succulents', 10, 3);


