# Engeto Java Academy - Project VAT
### Additional project for Engeto Java Academy
---
## **Project description**
This project is designed to read and sort States from csv file.
It sorts the States based on your input of the limit of the VAT tax.
All States above / bellow the limit are stored and states that are above limit are pritned into txt file.
If you hit just enter the limit value is set to 20 by default.

### Project preview:
When you run the program: 
```
All states: 
Austria (AT): 20.0 %
Belgium (BE): 21.0 %
Bulgaria (BG): 20.0 %
Cyprus (CY): 19.0 %
Czech Republic (CZ): 21.0 %
Denmark (DK): 25.0 %
Germany (DE): 19.0 %
Estonia (EE): 20.0 %
Greece (GR): 24.0 %
Spain (ES): 21.0 %
Finland (FI): 24.0 %
France (FR): 20.0 %
Croatia (HR): 25.0 %
Italy (IT): 22.0 %
Latvia (LV): 21.0 %
Lithuania (LT): 21.0 %
Luxembourg (LU): 17.0 %
Hungary (HU): 27.0 %
Ireland (IE): 23.0 %
Malta (MT): 18.0 %
Netherlands (NL): 21.0 %
Poland (PL): 23.0 %
Portugal (PT): 23.0 %
Romania (RO): 20.0 %
Slovenia (SI): 22.0 %
Slovakia (SK): 20.0 %
Sweden (SE): 25.0 %
United Kingdom (GB): 20.0 %
_____

Please enter the VAT limit to sort the sates: (Default is 20)
```
Example when you enter limit 23:
```
All states with VAT over 23% and not using special tax: 
Denmark (DK): 25.0 %
Greece (GR): 24.0 %
Finland (FI): 24.0 %
Croatia (HR): 25.0 %
Hungary (HU): 27.0 %
Sweden (SE): 25.0 %
_____

States above sorted by VAT, descends:
Hungary (HU): 27.0 %
Denmark (DK): 25.0 %
Croatia (HR): 25.0 %
Sweden (SE): 25.0 %
Greece (GR): 24.0 %
Finland (FI): 24.0 %
====================
States with VAT 23% or lower or using special tax: AT, BE, BG, CY, CZ, DE, EE, ES, FR, IT, LV, LT, LU, IE, MT, NL, PL, PT, RO, SI, SK, GB, 
```
Result is saved in txt. Name of txt inclides your enterd limit "vat-over-23.txt":
```
HU	Hungary	27.0	18.0	false
DK	Denmark	25.0	25.0	false
HR	Croatia	25.0	13.0	false
SE	Sweden	25.0	12.0	false
GR	Greece	24.0	13.0	false
FI	Finland	24.0	14.0	false

```
