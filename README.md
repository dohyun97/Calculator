# Calculator
When you use this url http://localhost:8080/Kim-OsapCalc-v4/Osap , it'll show calculate result with the values of prinipal, period and interest set by XML

![F4E87053-9777-4A60-A5D6-E191E4096D49_4_5005_c](https://user-images.githubusercontent.com/84333692/214945228-e5c93cc4-d8f3-4489-a0a3-a99494206b8b.jpeg)

http://localhost:8080/Kim-OsapCalc-v4/Osap?period=12&?principal=1234&interest=10 shows the monthly payment result with the value of period=12&?principal=1234&interest=10
![E96EE4B7-974C-465C-9E1C-8DC1CABB7F3E_4_5005_c](https://user-images.githubusercontent.com/84333692/214945616-5322be9c-af68-4e6d-beb5-3adc08789aa4.jpeg)

I made Listener to monitor the "principal" value across all requests and sesions. It calculates the maximum principal across all principal values and keep this value in memory. You can see maximum principal in http://localhost:8080/Kim-OsapCalc-v4/admin

![A5AC6321-957A-4304-8C71-FC1AEFCBC67C_4_5005_c](https://user-images.githubusercontent.com/84333692/214947219-9e45f996-7fc1-4327-a9bc-2708a141adab.jpeg)


In the http://localhost:8080/Kim-OsapCalc-v4/UI.html
"Principal" and "Period" should be greater than 0, "Interest rate" should be between 0 and 100. If not, you will get alret and red mark beside name.
![91319A2D-2213-407C-BA9A-0BFFCD322581](https://user-images.githubusercontent.com/84333692/214944339-bbd9deea-476d-4781-9d09-a87180e0737e.jpeg)
![FCF51E65-4E70-447B-AF60-0CB504D5B256](https://user-images.githubusercontent.com/84333692/214944349-8a38e1af-1855-47e4-a79f-27a7b72ed1d3.jpeg)

Once you click the Submit button, it'll show result and can click the recompute button. The recompute button will restart
![B700B73F-EF79-4476-82B7-65404ECFB0EB](https://user-images.githubusercontent.com/84333692/214946000-50dc5d1e-43c4-489a-8201-a3af16adcbd7.jpeg)
![FF611CA2-B166-4CAB-928E-7AD337CDE0AD](https://user-images.githubusercontent.com/84333692/214946147-9877ff3f-e6c0-40c5-907e-0bcb7220cafe.jpeg)

Also, you can submit by AJAX.
![15FF55A8-B6FE-4E62-9777-BAB3D2400599](https://user-images.githubusercontent.com/84333692/214946343-700bead2-f18e-496f-ba5b-79f5872e68aa.jpeg)
