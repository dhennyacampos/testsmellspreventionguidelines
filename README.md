<p align="center">
 <img width="300px" src="image.png" align="center" alt=""/>
 <h2>Welcome 👋</h2>
</p>

<p align="justify">📌 This reade.me  xxxx </i> xxx </p>

<p align="justify">📎 Link to paper <a href="testsmells">[not available]</a></p>

<p align="justify">📋 <b>Abstract:</b>xxxxxx</p>  


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
If your <b> test code</b> contains any of the following structures, your test case may contain <b>"test smells"</b>.

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
et al., 2016; PERUMA, 2018; GAROUSI, 2018; ALJEDAANI et al., 2021).  The literature presents several types of test smells. GAROUSI, 2018 presents a catalog with more than 80 ones.
For this study, we will address the 6 most cited test smells in the literature, which are:

* Assertion Roulette (AR)
* Conditional Logic Test (CTL)
* Duplicate Assert (DA)
* Resource Optimism (RO)
* Sleepy Test (ST)
* Unknown Test (UT)

<p> ➡ See <a href="testsmells.md" >definitions and exemplo </a> of test smells</p>

<p align="center">
 <h2>Test smells prevention 🧹</h2>
</p>

To prevent these kinds of problems known as <b>"test smells"</b> from occurring in test code, it is important to avoid certain scripting structures in the test code. 
In the following we will show some structures that will help developers avoid having the following test smells in their test code.

<p> ➡ See <a href="testcodreprevention.md" >prevention and exemplo </a> of test smells</p>

<p align="center">
 <h2>Contributions 🤝</h2>
</p>

<p align="justify">Contributions to maintain this summary up to date are appreciated and encouraged. Please submit your pull request. </p>
