# Universidad de Sevilla
## Escuela Técnica Superior de Ingeniería Informática
&nbsp;
&nbsp;
# L4 - ITIL


![logo us](../images/L2-8-image-logo_us_300.gif)

## Grado en Ingeniería Informática - Ingeniería del Software

## Proceso de Software y Gestión 2
## Curso 2018 - 2019

| Fecha     |    |Revisión |
|-----------|----|----------|
|19/05/2019 |    |v01e00|


Grupo de Prácticas: G5-50

| Autores |     | Rol |
|---------|-----|------|
| González Valiñas, Pedro Agustín |  | Scrum Master |
| Delgado Luna, Ángel             |  | Team member |
| Novoa Montero, Ana María        |  | Team member |
| Pérez Capitán, Sergio           |  | Team member |
| Rosado Bornes, Víctor           |  | Team member |
| Sánchez Hipona, Antonio         |  | Team member |

&nbsp;
# EXTRA - Analyze the issues of the previous sprints

| Índice |
|--------|
| [1. Analyse previous sprints.](#1-analyse-previous-sprints) |


## 1. Analyse previous sprints

A continuación se indica la tabla del report A43, en la que se muestran las issues y sus respectivos valores, como el tiempo en días y el valor de sus puntos de historia. Así como se especifica si se cumple o no con la SLO.
La SLO hace referencia en nuestro al número de días requerido para cumplir con una issue, considerando su inicio desde su estimación de puntos de historia hasta que finalmente se termina y cierra.


| Completed Issues | Issue started | Issue Closed | Time in days | Estimate history points | Complies with the SLO ? | 
| -----------------| --------------| -------------| -------------| ------------------------| ------------------------|
|A2.2.2 (5%) - Clone repo and initPSG2-1819-G5-50 #1	| Feb 26	| Feb 27	| 1	| 1 | No |
|A2.2.3.e - Translate messages to SpanishPSG2-1819-G5-50 #6 |	Feb 26	| Mar 2	| 4	| 2 | No |
|A2.2.3.d - Owner DELETE his petsPSG2-1819-G5-50 #5	| Feb 26	| Mar 6	| 8	| 3 | Sí |
|A2.2.3.c - Change welcomePage messagePSG2-1819-G5-50 #4	| Feb 26	| Mar 6	|8	| 2 | Sí |
|A2.2.3.a - Change header colorPSG2-1819-G5-50 #2 |	Feb 26 |	Mar 6 |	8 |	3 | Sí |
|A2.2.3.b - Change background colorPSG2-1819-G5-50 #3	| Feb 26	| Mar 8	| 10	| 2 | Sí |
|A2.2.3.f - Change background color when looking for OwnersPSG2-1819-G5-50 #7	| Feb 26	| Mar 9	| 11	| 3 | Sí |
|A2.3.3.d - Owner, Pet, Veterinarian DELETEPSG2-1819-G5-50 #16	| Feb 26	| Mar 10	| 12	| 8 | Sí |
|A.2.3.3.c - Veterian CREATE and EDIT functionallityPSG2-1819-G5-50 #15	| Feb 26	| Mar 13	| 15	| 21 | Sí |
|A2.3.3.a - Create PetHotelPSG2-1819-G5-50 #13	| Feb 26	| Mar 15	| 17	| 21 | Sí |
|A.2.3.3.b - Reassign logos, fonts & colors of the pagesPSG2-1819-G5-50 #14	| Feb 26	| Mar 17	| 19	| 5 | No |
|A.2.3.4 - Prepare a release of the Petclinic projectPSG2-1819-G5-50 #17 |	Feb 26 |	Mar 18 | 20	| 13 | No |
|CAUSE - Domain modelPSG2-1819-G5-50 #21	| Mar 22	| Apr 2	| 11	| 3 | Sí |
|CAUSE - repo and servicePSG2-1819-G5-50 #22	| Mar 22	| Apr 2	| 11	| 5 | Sí |
|DONATION - Domain modelPSG2-1819-G5-50 #25	| Mar 22	| Apr 2	| 11	| 3 | Sí |
|DONATION - repo and servicePSG2-1819-G5-50 #26	| Mar 22	|Apr 2	| 11 |	8 | Sí |
|CAUSE - views and controllerPSG2-1819-G5-50 #23 |	Mar 22 |	Apr 2 |	11 |	13 | Sí |
|DONATION - views and controllerPSG2-1819-G5-50 #27	| Mar 22	| Apr 4	| 13	| 13 | Sí |
|Validate Booking CreationPSG2-1819-G5-50 #19	| Mar 20	| Apr 4 | 	15	| 5 | Sí|

En esta tabla observamos que de manera sorprendente, se quedan fuera del intervalo de confianza las issues que menos tiempo necesitaron para ser realizadas (A222 y A223e). Esto se debe a que la distribución gaussiana pone su centro en los valores promedios, con lo cual, cuando se producen demoras significativas, esto repercute en el resultado, haciendo que las issues más rápidas en finalizarse, salgan del intervalo de confianza.

En la siguiente imagen, comprobamos que existen valores que se salen del intervalo tanto al principio o como al final.

<img src="../images/L4-38-image-gauss_bell.png" alt="drawing" width="600"/>

Esta otra imagen nos permite identificar inequívocamente, qué 4 puntos son los que salen del 99,7%.

<img src="../images/L4-38-image-planar_probability_density.png" alt="drawing" width="600"/>

Entendido el problema, la solución para poder garantizar el valor de la SLO del 99,7% pasa por disminuir la demora en la realización y cierre de las issues. Eso supondría que podríamos estar dentro del valor esperado, por lo que no tendríamos demasiada probabilidad de sufrir penalizaciones en nuestro servicio.

Si continuáramos como hasta el momento, podríamos garantizar un valor del 99.7% en nuestro SLA ya que sólo nos desviamos en un 0,3% y esa penalización no será muy elevada.