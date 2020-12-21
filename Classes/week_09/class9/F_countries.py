import json
# This example wa taken from:CCPS 109 Computer Science, Ryerson University, Toronto.
# See: https://github.com/ikokkari/PythonExamples
# {
#         "Name": "Isle of Man",
#         "Population": "86159 people",
#         "Continent": "Europe",
#         "Area": "572 kilometers squared",
#         "GDP": "7428280401 US dollars per year",
#         "NaturalHazards": []
#     },
#     {
#         "Name": "Israel",
#         "Population": "7939745 people",
#         "Continent": "Asia",
#         "Area": "20770 kilometers squared",
#         "GDP": "299415714726 US dollars per year",
#         "NaturalHazards": [
#             "drought",
#             "dust storm",
#             "earthquake"
#         ]
#     },
#     {
#         "Name": "Italy",
#         "Population": "61175248 people",
#         "Continent": "Europe",
#         "Area": "301340 kilometers squared",
#         "GDP": "1821496964400 US dollars per year",
#         "NaturalHazards": [
#             "avalanche",
#             "earthquake",
#             "flood",
#             "landslide",
#             "land subsidence",
#             "volcano"
#         ]
#     },...

#with open('countries.json', encoding="utf-8") as data_file:
#    countries = json.load(data_file)

json_file = open('countries.json', encoding="utf-8")
countries = json.load(json_file)
json_file.close()

print("Read ",len(countries)," countries from the JSON file.")

continental_pops = {}
total_pop = 0
for country in countries:
    continent = country["Continent"]
    pop = int(country["Population"].split(" ")[0])
    continental_pops[continent] = continental_pops.get(continent, 0) + pop
    total_pop += pop

print("\nThe total population in each continent:")
for continent in sorted(continental_pops.keys(),
                        key=lambda c: continental_pops[c],
                        reverse=True):
    people = continental_pops[continent]
    print(continent," has a total of ",people," people.")
print("That gives a total of ",total_pop," people on Earth.")

hazard_table = {}
for country in countries:
    hazards = country["NaturalHazards"]
    for hazard in hazards:
        hazard_table[hazard] = hazard_table.get(hazard, 0) + 1

print("\nHere are the natural hazards found around the world.")
for hazard in sorted(hazard_table,
                     key=lambda haz: hazard_table[haz],
                     reverse=True):
    title = hazard[0].upper() + hazard[1:]
    haz_count = hazard_table[hazard]
    print(f"{title} is a hazard in {haz_count} countries.")
