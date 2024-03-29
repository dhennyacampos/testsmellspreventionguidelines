<p align="center">
 <img width="500px" src="image.png" align="center" alt=""/>
 <h2>Welcome 👋</h2>
</p>

<p align="justify">📌 This reade.me   </i> shows test smells prevention guidelines. This guide first presents the structures of test codes that can be indicators of the presence of test smells. Secondly, we present the definition of six types of test smells. Third, we present a guideline on how to prevent the insertion of these six test smells in the test code; then, we validate this guideline through an experiment.  </p>

<p align="justify">📎 Link to paper <a href="testsmells">[not available]</a></p>

<p align="justify">📋 <b>Abstract:</b>Software development is a collaborative and social activity that necessitates the knowledge and expertise of multiple individuals. Software development is more than just coding and programming. It includes many human-centered characteristics, such as communication and personality, which can have a substantial impact on the success of software projects and code quality. Several studies in the literature address the quality of test code and the corrections of test smells and their refactorings. However, little empirical evidence exists on human aspects and test code quality. Our previous works investigated the relationship between developer experience, test creation, and maintenance strategies through developers' perceptions and test code quality. This study aims to create and validate a set of guidelines to prevent the insertion of 6 types of test smells when creating and maintaining test cases during the software evolution. In this sense, we want to derive a set of guidelines based on our previous studies. Based on shared knowledge and developers' experiences, we have created a set of guidelines to help developers avoid inserting test smells when creating unit test classes. The results of this research point to the effectiveness and applicability of the test smell prevention guidelines, showing a positive relationship through high Cronbach's alpha coefficients. In addition, the study reports the importance of considering developers' diverse experiences and perspectives in developing and implementing test guidelines, highlighting that even those familiar with JUnit faced challenges when creating test cases.</p>  



![JAVA](https://img.shields.io/badge/java%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=F745B5)
![JUNIT](https://img.shields.io/badge/JUNIT%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=00add8)
![testsmell](https://img.shields.io/badge/testsmell%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=dc322f)
![refactoring](https://img.shields.io/badge/refactoring%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=404d59)

![SoftwareEngineering](https://img.shields.io/badge/SoftwareEngineering%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=ffb800)
![Developers'perception](https://img.shields.io/badge/Developers'perception%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=f7df1f)
![Software Maintenance](https://img.shields.io/badge/SoftwareMaintenance%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=f57a17)
![Evolution](https://img.shields.io/badge/Evolution%20-%23323330.svg?&style=for-the-badge&logo=perfil&logoColor=black&color=777bb4)

<p align="center">
 <h2>Test code </h2>
</p>
To ensure that the test cases are of the highest quality, it is essential to check whether our test code contains structures that may negatively affect the 
effectiveness of our tests. The following structures can be harmful to test code and may be indicators of the presence of <b>"test smells"</b>.


* A test method that contains multiple assertion statements without an argument as a parameter;
* A test method that contains one or more control statements, i.e, if, switch, conditional expression, for, foreach, or while statements;
* Method with more than one assertion statement with the same parameters;
* Method contains an instance of a File class without calling the methods Exists(), isFile() or noExists() methods of the object;
* Method that invokes the Thread.sleep() method;
* Method does not contain a single assertion statement and @Test (expected) annotation parameter.


<p align="center">
 <h2>What are test smells? 🐞</h2>
</p>

<b>Test smells</b> are indications of problems or bad practices in software testing that can lead to inefficient testing or even failure to identify software problems s (PALOMBA
et al., 2016; PERUMA et. al, 2018; GAROUSI, 2018; ALJEDAANI et al., 2021).  The literature presents several types of test smells. GAROUSI, 2018 presents a catalog with more than 80 ones.
For this study, we will address the 6 most cited test smells in the literature, which are:

* Assertion Roulette (AR)
* Conditional Logic Test (CTL)
* Duplicate Assert (DA)
* Resource Optimism (RO)
* Sleepy Test (ST)
* Unknown Test (UT)

<p> ➡ See <a href="testsmells.md" >definitions and exemplo </a> of test smells</p>

<p align="center">
 <h2>Test smells prevention guideline 🧹</h2>
</p>

To prevent these kinds of problems known as <b>" test smells"</b> from occurring in test code, it is important to avoid certain scripting structures in the test code. 
In the following, we will show some structures that will help developers avoid having the following test smells in their test code. These suggested preventions are
based on the JUnit 4 framework.

<p> ➡ See <a href="testcodreprevention.md" >prevention and exemplo </a> of test smells</p>

<p align="center">
 <h2> Guideline evaluation </h2>
</p>

In this section, we will present two initiatives that will be carried out by the core and peripheral development teams. The purpose of these activities is to confirm the applicability of our guidelines.

<p> ➡ See <a href="guidelineevaluation.md" >  guideline evaluation </a> on test smells</p>

<p align="center">
 <h2>Contributions 🤝</h2>
</p>

<p align="justify">Contributions to maintain this summary up to date are appreciated and encouraged. Please submit your pull request. </p>
