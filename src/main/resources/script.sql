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
                                                        ('Every other day', 9, 1),
                                                        ('Once a week', 9, 2),
                                                        ('Every two weeks', 9, 3),
                                                        ('Once a month or less', 9, 4),
                                                        ('Green leafy plants', 10, 1),
                                                        ('Flowering plants', 10, 2),
                                                        ('Cacti and succulents', 10, 3);


INSERT INTO Family (
    image_path,
    colloquial_name,
    scientific_name,
    description,
    light_hours,
    light_type,
    light_orientation,
    size,
    exhibit,
    humidity,
    temperature,
    toxicity,
    watering,
    type
) VALUES (
             'https://unsplash.com/es/fotos/planta-verde-y-roja-en-maceta-de-barro-marron-tSWTSzwSz6M',
             'Chinese Evergreen',
             'aglaonema',
             'Ideal as a houseplant for bright to moderately bright rooms. Commonly known as Chinese evergreen, is an evergreen perennial resembling dieffenbachia (dumb cane). It typically grows up to around 20” (50 cm) tall with elliptic, thick, dark green leaves (10-20 cm long and 5-8 cm wide) featuring sometimes branched stems. Prefers diffused sun or good indirect light, avoiding direct sun. Use a well-drained, peaty potting mixture. Maintain consistent moisture from spring to fall. While it doesn\'t require winter dormancy, it benefits from a rest period during winter. Reduce watering from early fall to late winter, ensuring soils do not dry out. This plant tolerates atmospheric dryness and somewhat shady locations, with a normal room temperature and a minimum winter temperature of 60°F (15°C). As a houseplant, it rarely flowers. Watch for aphids, mealybugs, spider mites, or scale. Rots may occur if the plant is overwatered. Leaves may brown if the plant is in very dry air or placed in a drafty location. The genus name comes from the Greek words aglaos, meaning bright or clear, and nema, meaning a thread, referring to the stamens.',
             '2,3',
             '2,3',
             '1,3,4',
             '2,3',
             '1,2',
             '2,3',
             '3,4',
             '1,2,3',
             '1,2',
             '1'
         );

INSERT INTO Plant (image_path, name, description, family)
VALUES (
           'https://imgix.be.green/6364c90609e5c840195824.jpg',
           'Silver Bay',
           'Aglaonema ''Silver Queen'', also known as painted drop tongue, is a free-branching evergreen perennial that typically reaches 24 inches (60 cm) in height. This popular houseplant thrives in low light and is prized for its striking variegated foliage rather than its insignificant flowers. The plant features thick, elliptic to lance-shaped, dark green leaves that are 4-6 inches (10-15 cm) long and 2-3 inches (5-8 cm) wide, adorned with attractive silver-gray variegation. The leaves have silvery-white centers with green margins and veins, growing on short stems emerging from the soil. As the plant matures, it develops a trunk-like stem as the lower leaves shed. Flowers, characteristic of the arum family, consist of a small creamy white spadix surrounded by a greenish-yellow spathe, typically blooming from summer to early fall. These flowers are followed by clusters of orange berries, though both flowers and fruit are rarely produced indoors.',
           (SELECT id FROM Family WHERE scientific_name = 'aglaonema')
       );

INSERT INTO Plant (image_path, name, description, family)
VALUES (
           'https://promisesupply.ca/cdn/shop/products/AgloneamaRedGold6_-995square.jpg?v=1618255654&width=1946',
           'Red Gold',
           'Aglaonema ''Red Gold'' is a hybrid selection of Chinese evergreen featuring glossy green foliage with red margins and red and yellow streaks. Mature plants can reach up to 3 feet (90 cm) in height with an equal spread. Typical arum-type inflorescences,
           consisting of a pale pink to white spathe surrounding a white spadix, are produced seasonally to rarely depending on cultural conditions.',
           (SELECT id FROM Family WHERE scientific_name = 'aglaonema')
       );

INSERT INTO Plant (image_path, name, description, family)
VALUES (
           'https://zielony-parapet.pl/17329-thickbox_default/aglaonema-cutlass-aglonema.jpg',
           'Cutlass',
           'Aglaonema ''Cutlass'' is a hybrid selection of Chinese evergreen featuring long, slender, lanceolate, grey - green foliage with darker green margins and streaks. Mature plants can reach up to 4 feet (120 cm) in height with a similar spread. Typical arum-type inflorescences are produced seasonally to rarely depending on cultural conditions. This plant is primarily grown for its showy foliage rather than its blooms.',
           (SELECT id FROM Family WHERE scientific_name = 'aglaonema')
       );



INSERT INTO Family (
    image_path,
    colloquial_name,
    scientific_name,
    description,
    light_hours,
    light_type,
    light_orientation,
    size,
    exhibit,
    humidity,
    temperature,
    toxicity,
    watering,
    type
) VALUES (
             'https://unsplash.com/es/fotos/hojas-verdes-en-la-lente-de-cambio-de-inclinacion-IQaMIFWD_ug',
             'Prayer Plant',
             'Calathea',
             'With good humidity, consistent soil moisture, warm air temperature, and an absence of direct sun, this tropical perennial will usually develop into an extremely attractive indoor foliage plant. Best indoor container growth typically occurs in uniformly moist, well-drained, peaty potting mixtures in room temperatures ranging from 65-75°F in limited sun to bright shade locations. Avoid full sun, particularly in the heat of the afternoon. Tolerates some early morning sun or diffused sun. Avoid drafts or sudden temperature changes. Plants need high humidity which can often be difficult to provide in winter. Consider standing a potted plant on a bed of wet pebbles, misting the foliage regularly and/or growing the plant in a humidified room. During the growing season (April-August), water regularly to keep soils moist (but not wet) and apply a balanced fertilizer monthly. Reduce watering and fertilization in winter when plant growth typically slows down. Propagate by division.
Genus name comes from the Latin word calathus meaning basket in reference to the inflorescence looking like a basket of flowers.
',
             '2,3',
             '1,2',
             '1,3,4',
             '2',
             '1,2',
             '2,3,4',
             '2,3',
             '4',
             '1,2',
             '1'
         );

INSERT INTO Plant (image_path, name, description, family)
VALUES (
           'https://unsplash.com/es/fotos/planta-verde-y-marron-en-maceta-de-barro-marron-uqyKhRVXCmk',
           'Ornata',
           'Calathea ornata, also known as the pinstripe plant, is a tropical houseplant and considered one of the most elegant types of calatheas. It''s known for its wide, pointed dark green leaves marked with sets of thin stripes in creamy white or pink. The pinstripe plant grows best in bright, indirect light, moist soil, temperatures between 65 to 85 degrees Fahrenheit, and high humidity.
Water your Calathea ornata consistently so that the soil stays moist but not soggy. Overwatering can cause root rot, which can kill the plant. Avoid letting the soil dry out beyond the top inch or so between waterings.
Keep this tropical plant in a place with moderate temperatures and lots of humidity. If your space is particularly dry, group your plant in with other plants in your collection to help create a more humid microclimate, or run a humidifier nearby to add moisture to the air.
',
           (SELECT id FROM Family WHERE scientific_name = 'Calathea')
       );


INSERT INTO Plant (image_path, name, description, family)
VALUES (
           'https://unsplash.com/es/fotos/persona-sosteniendo-planta-verde-en-maceta-de-ceramica-blanca-KeHEsF-0Xmg',
           'Lancifolia',
           'Rattlesnake plant (Goeppertia insignis) is a tropical evergreen perennial native to Brazil, commonly grown as an indoor houseplant. It can be tricky to nurture and isn''t the easiest houseplant for beginners since it has particular heat, light and moisture requirements.

But, if you give it the care it needs, you will be rewarded with an impressive foliage display with a wavy pattern along the edges and variegated with shades of greens. Even the undersides of the foliage are eye-catching with their beautiful purplish-red tones.
Keep your rattlesnake plant in a space with filtered light. If you want to place your plant in a window, select one that doesn''t have intense afternoon sun streaming through it, or diffuse the light with drapes. A bright spot in a well-lit room works well.
Water your rattlesnake plant frequently in the summer to keep the soil moist. During the winter season, allow the top layer of soil to dry out before watering again.

If the leaves start to turn yellow, you may be overwatering. Conversely, if the leaves begin to curl unattractively they aren''t receiving enough water.

Water the plant until it just starts to trickle out of drainage holes (not so much that water is streaming out of the bottom). Do not let the plant sit in excess water.
Create a humid environment by standing your potted plant on a tray with pebbles. This helps create a moist environment. You can also regularly mist your plant, bring it into the bathroom when showering, and invest in a humidifier.

',
           (SELECT id FROM Family WHERE scientific_name = 'Calathea')
       );

INSERT INTO Plant (image_path, name, description, family)
VALUES (
           'https://www.hola.com/horizon/original_aspect_ratio/65f09006c544-calathea-roseopicta-03a-a.jpg',
           'Roseopicta',
           'With good humidity, consistent soil moisture, warm air temperature, and an absence of direct sun, this tropical perennial will usually develop into an extremely attractive indoor foliage plant. Best indoor container growth typically occurs in uniformly moist, well-drained, peaty potting mixtures in room temperatures ranging from 65 to 75°F in bright shade locations. Avoid full sun, particularly in the heat of the afternoon. Tolerates some early morning sun or diffused sun. Plants need high humidity which can often be difficult to provide in winter. Consider standing a potted plant on a bed of wet pebbles, misting the foliage regularly and/or growing the plant in a humidified room. Water regularly to keep soils moist (but not wet) during the growing season. Reduce watering in winter when plant growth typically slows down.
Watch for aphids, scale, mealybugs and spider mites. Leaf spots may appear. Plants do not thrive in low humidity where leaves may roll or turn brown. Direct sun usually causes leaf scorch.
',
           (SELECT id FROM Family WHERE scientific_name = 'Calathea')
       );