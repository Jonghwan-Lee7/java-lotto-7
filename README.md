## 🎰 java-lotto 🎰

---

## 📚  목차

1. 📔  [패키지 구조](#-패키지-구조)
2. 🗺 [프로그램 플로우 및 구현 기능](#-프로그램-플로우-및-구현-기능)
3. ❓ [테스트 목록](#-테스트-목록)
4. 🔍 [고민했던 요소](#-고민했던-요소)
5. ⭐ [설계 시 주요 포인트](#-설계-시-주요-포인트)


---

## 📔 패키지 구조

<div align="center">
<table>
<tr>
<th align="center">Package</th>
<th align="center">Class</th>
<th align="center">Description</th>
</tr>

<tr>
<td rowspan="3"><b>⚙️  config</b></td>
<td><b> AppConfig</b></td>
<td>  애플리케이션의 전반적인 설정과 의존성 주입을 관리하는 구성 클래스 </td>
</tr>

<tr>
<td><b> DtoMapperConfig</b></td>
<td> DTO 변환을 위한 매퍼 설정을 정의하는 구성 클래스 </td>
</tr>

<tr>
<td><b> ValidatorConfig</b></td>
<td>입력 검증 로직을 위한 유효성 검사기 설정을 제공하는 구성 클래스 </td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="2"><b> 🔢️  constants</b></td>
<td><b> LottoRank </b></td>
<td>  로또 당첨 조건, 당첨 금액 등의 상수를 보관하는 enum 클래스 </td>
</tr>

<tr>
<td><b> LottoTicket </b></td>
<td> 로또 번호의 범위, 하나의 로또 티켓의 번호 갯수 등 로또 티켓 하나의 정보를 가지는 enum 클래스  </td>
</tr>


<tr><td colspan="3"></td></tr>



<tr>
<td><b>🕹&nbsp;&nbsp;controller</b></td>
<td><b> LottoGameController </b></td>
<td> 로또 로직을 메인으로 동작하는 컨트롤러 클래스 </td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="10"><b>💻  domain</b></td>
<td><b> MatchResult</b></td>
<td> winningLotto와 로또 한 장을 비교한 결과를 저장하는 클래스</td>
</tr>

<tr>
<td><b> MatchResults</b></td>
<td> MatchResult 객체 리스트를 가지는 일급 컬렉션 </td>
</tr>

<tr>
<td><b> RankDecider </b></td>
<td> MatchResult를 보고 등수를 결정하는 기능의 클래스 </td>
</tr>

<tr>
<td><b> WinningLotto</b></td>
<td> 당첨 번호와 보너스 번호 정보 및 관련 메서드가 있는 클래스 </td>
</tr>

<tr>
<td><b> DefaultLottoFactory</b></td>
<td> LottoFactory의 구현체 </td>
</tr>

<tr>
<td><b> Lotto</b></td>
<td> 로또 한 장의 번호 정보를 가지고 있는 클래스  </td>
</tr>

<tr>
<td><b> LottoFactory</b></td>
<td> Lotto 객체 생성 Factory Interface </td>
</tr>

<tr>
<td><b> LottoNumbersGenerator</b></td>
<td> 임의의 로또 번호를 생성하는 NumberGenerator의 구현체 </td>
</tr>

<tr>
<td><b> Lottos</b></td>
<td> Lotto 객체 리스트를 갖는 일급 컬렉션 </td>
</tr>

<tr>
<td><b> NumberGenerator</b></td>
<td> 임의의 숫자를 생성하는 기능의 Interface </td>
</tr>


<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="5"><b>✉️&nbsp;&nbsp;dto</b></td>
<td><b> FinalResultsDto</b></td>
<td> 라운드 별 모든 자동차의 이름 및 위치 정보를 리턴하는 DTO 레코드 </td>
</tr>


<tr>
<td><b> LottoDto </b></td>
<td> 로또 한 장의 번호 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr>
<td><b> LottosDto</b></td>
<td> 로또들의 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr>
<td><b> ProfitDto</b></td>
<td> 수익과 수익률을 리턴하는 DTO 레코드 </td>
</tr>


<tr>
<td><b> RankResultsDto </b></td>
<td> 등수 관련 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="1"><b>🚫&nbsp;&nbsp;exception</b></td>
<td><b> ErrorMessage </b></td>
<td> 예외 발생 시 사용되는 에러 메세지 Enum 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="7"><b>💼&nbsp;&nbsp;service</b></td>
<td><b> DtoMapper  </b></td>
<td> DTO의 Mapper 담당 Interface</td>
</tr>

<tr>
<td><b> LottoDtoMapper  </b></td>
<td> LottoDto 생성  Mapper 클래서</td>
</tr>

<tr>
<td><b> LottosDtoMapper  </b></td>
<td> LottosDto 생성 Mapper 클래스 </td>
</tr>

<tr>
<td><b> LottoPurchaseService  </b></td>
<td> 발행한 로또와 당첨번호를 비교하여 결과값 산출하는 Interface </td>
</tr>


<tr>
<td><b> LottoPurchaseServiceImpl  </b></td>
<td> LottoPurchaseService의 구현체 </td>
</tr>

<tr>
<td><b> LottoResultService  </b></td>
<td> 입력값에 맞춰 로또를 발행하는 기능의 서비스 Interface</td>
</tr>

<tr>
<td><b> LottoResultServiceImpl  </b></td>
<td> LottoResultService의 구현체 </td>
</tr>


<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="11"><b>🌟&nbsp;&nbsp;utils</b></td>

<td><b> constants </b></td>
<td> 검증, 파싱 과정에서 사용되는 상수 보관 enum 클래스</td>
</tr>

<tr>
<td><b> BonusNumberValidator </b></td>
<td> 입력된 보너스 번호의 유효성 검증을 담당하는 클래스</td>
</tr>

<tr>
<td><b> ComparisonValidator </b></td>
<td> 입력값을 다른 값과 비교하여 유효성을 검증하는 Interface </td>
</tr>

<tr>
<td><b> InputValidator </b></td>
<td> 입력값을 검증하는 validator 클래스들의 Interface</td>
</tr>

<tr>
<td><b> LottoNumberValidator </b></td>
<td> 숫자가 로또 번호로 유효한 지 검증하는 클래스</td>
</tr>

<tr>
<td><b> PositiveIntValidator </b></td>
<td> 입력값의 양의 정수 여부 검증 클래스</td>
</tr>

<tr>
<td><b> PurchaseAmountValidator </b></td>
<td> 입력한 구매 금액의 유효성 검증 클래스 </td>
</tr>

<tr>
<td><b> WinningNumbersValidator </b></td>
<td> 입력한 당첨 번호들의 유효성 검증 클래스 </td>
</tr>

<tr>
<td><b> Parser </b></td>
<td> 각종 파싱 클래스의 Interface</td>
</tr>

<tr>
<td><b> StringToIntListParser </b></td>
<td> String -> Integer List 로의 변환 담당 클래스</td>
</tr>

<tr>
<td><b> StringToIntParser </b></td>
<td> String ->Int 로의 변환 담당 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="7"><b>💬&nbsp;&nbsp;view</b></td>
<td><b> InputMessages </b></td>
<td> 사용자 입력 관련 안내 메세지지를 저장하는 enum 클래스</td>
</tr>

<tr>
<td><b> NumberOutputFormat </b></td>
<td> 출력시 숫자 포맷 정보를 저장하는 enum 클래스</td>
</tr>


<tr>
<td><b> OutputMessages </b></td>
<td> 출력 메세지를 저장하는 enum클래스 </td>
</tr>

<tr>
<td><b> ConsoleInputView </b></td>

<td> 사용자에게 입력을 받는 기능을 담당하는 클래스 </td>
</tr>

<tr>
<td><b> InputView </b></td>

<td> Input 클래스 Interface </td>
</tr>


<tr>
<td><b> ConsoleOutputView </b></td>
<td> 사용자에게 응답을 출력하는 클래스</td>
</tr>




<tr>
<td><b> OutputView </b></td>

<td> Output 클래스 Interface </td>
</tr>




</table>
</div>




---

## 🗺️   프로그램 플로우 및 구현 기능

- ✅ ```ConsoleInputView``` **구입 금액 관련 안내 문구를 출력한다.**

- ✅ ```ConsoleInputView``` **로또 구입 금액을 입력받는다.** 
  - ☑️ ```PurchaseAmountValidator``` 유효하지 않은 값이 들어오면 예외처리 한다.
    - ✔️ 인풋이 비어있는 경우 예외처리 한다. 
    - ✔️숫자가 아닌 경우 예외처리 한다.
      -  공백이 포함되어 있는 경우 또한 동일하다.
    - ✔️ 숫자이지만 정수가 아니면 예외 처리 한다.
    - ✔️ 정수이지만 양수가 아니면 예외처리 한다.
    - ✔️ 정수이지만 1000원으로 나누어 떨어지지 않는 경우 예외처리 한다.
    - ✔️ 100000을 넘어가는 값을 입력받으면 예외처리 한다.
      - 현행 법 상 개인의 로또 구매는 10만원이 최대이기에 이렇게 기준을 잡았다.
  - ☑️ ```LottoGameController```  예외가 발생한 경우, 에러메세지 출력 후 다시 입력 받는다.

<br>

- ✅ ```LottoPurchaseServiceImpl``` **로또를 발행한다.** 
  - ☑️ ```DefaultLottoFactory``` 로또 구입 금액 1000원 당 1 개의 로또를 발행한다.
  - ☑️ ```LottoNumbersGenerator``` 1 개의 로또를 발생할 때는 중복되지 않는 6개의 숫자를 뽑는다.
    - ✔️ 이때 숫자는 반드시 1 이상 45 이하의 정수여야 한다.

<br>

- ✅ ```LottoGameController```  **발행관련 정보를 ```LottosDTO``` 를 통해 view에게 전달한다.**


- ✅ ```ConsoleOutputView``` **발행한 로또 수량을 출력한다.**

- ✅ ```ConsoleOutputView``` **발행한 로또들의 번호를 출력한다**
  - ☑️  이때 로또 번호는 오름차순으로 정렬하여 보여준다.

<br>

- ✅ ```ConsoleInputView```  **당첨 번호 입력 안내문을 출력한다**
- ✅ ```ConsoleInputView``` **당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.**
  - ☑️ ```WinningNumbersValidator```  사용자가 잘못된 값을 입력할 경우 예외처리 한다. 
    - ✔️ 입력값이 비어있는 경우 예외처리 한다.
    - ✔️ 쉼표를 기준으로 분리된 각각의 원소가 숫자가 아닌 경우 예외처리 한다.
    - ✔️ 쉼표로 구분된 숫자의 갯수가 6개가 아닌경우 예외처리 한다.
    - ✔️ 각각의 숫자가 1이상 45이하의 정수가 아닌 경우 예외처리 한다.

  - ☑️ ```LottoGameController``` 예외가 발생한 경우, 에러메세지 출력 후 다시 입력 받는다.

<br>

- ✅ ```ConsoleInputView``` **보너스 번호 입력 안내문을 출력한다**

- ✅ ```ConsoleInputView``` **보너스 번호를 입력받는다**
  - ☑️ ```BonusNumberValidator``` 이때도 당첨 번호 한 개 숫자에 했던 예외처리를 동일하게 진행한다.
    - ✔️ 입력값이 비어있는 경우 예외처리 한다.
    - ✔️ 입력값이 숫자가 아닌 경우 예외처리 한다.
    - ✔️ 숫자가 1이상 45이하의 정수가 아닌 경우 예외처리 한다.
  - ☑️ ```LottoGameController``` 예외가 발생한 경우, 에러메세지 출력 후 다시 입력 받는다.

<br>

- ✅  ```LottoResultService``` **내부 로직을 통해 당첨 결과를 확인한다**
  - ☑️ ```LottoResultService``` 각각의 로또에 대하여 아래 로직을 진행한다.
    - ✔️ ```WinningLotto``` 당첨 번호와 몇개나 일치하는 지, 보너스 볼은 일치하는 지 확인한다.
    - ✔️ ```RankDecider``` 확인 결과에 따라 몇 등인지 결정한다.
    - ✔️ ```MatchResults``` 결과를 저장한다.


<br>

- ✅  ```LottoResultService``` **수익률을 계산한다**
  - ☑️  ```LottoResultService``` 위에서 구한 전체 결과를 통해 얼마를 얻었는 지 계산한다.
  - ☑️  ```LottoResultService```  총수익을 구매금액으로 나눈다.



<br>




- ✅  ```LottoResultService``` **결과를 ```FinalResultsDto```로 변환한다**
- ✅  ```LottoGameContorller``` **결과를 ```FinalResultsDto```로 변환한다**


<br>

- ✅ ```ConsoleOutputView``` **당첨 내역을 출력한다.**
  - ☑️ ```ConsoleOutputView```  5등부터 한 줄 씩  "x개 일치 (x,xxx,xxx원) - x개" 꼴로 출력한다.
    - ✔️ 이때 숫자는 세개 마다 쉼표(,)를 넣는다.
  - ☑️ ```ConsoleOutputView```  2등의 경우 위 형태 중간에 ', 보너스 볼 일치'가 추가 된다.

<br>

- ✅ ```ConsoleOutputView```  **수익률을 출력한다.**
  - ☑️ ```ConsoleOutputView```  이전에 계산해 놓았던 수익률을 "총 수익률은 xx.x%입니다."형태로 출력한다.


---

## ❓ 테스트 목록
<div>
<p align="center">
  <img src="" alt="첫 번째 이미지" width="40%" style="margin: 10px;" />
  <img src="" alt="두 번째 이미지" width="40%" style="margin: 10px;" />
</p>

<p align="center">
  <img src="" alt="첫 번째 이미지" width="40%" style="margin: 10px;" />
  <img src="" alt="두 번째 이미지" width="40%" style="margin: 10px;" />
</p>

<p align="center">
  <img src="" alt="첫 번째 이미지" width="40%" style="margin: 10px;" />
  <img src="" alt="두 번째 이미지" width="40%" style="margin: 10px;" />
</p>
</div>



----

## 🔍  고민했던 요소


----


## ⭐ 설계 시 주요 포인트

- **SOLD** 준수
- **MVC 패턴 준수**
    - 뷰, DTO, 서비스, 유틸, 도메인, 컨트롤러 등의 역할을 명확히 분리
- **DI 준수**
    - AppConfig, Factory 클래스 등을 이용하여 준수하자
- **YANGI 준수**
    - "You Aren't Gonna Need It", 지금 필요 없는 기능을 만들지 말자
- **KISS 준수**
    - "Keep It Simple Stupid" - 불필요하게 복잡해지는 것을 경계하자


- 매직 넘버, 에러메세지 등의 상수화 , 하드코딩 x - 상황에 따라 enum을 사용하자.
- 중복된 성질을 가진 여러 클래스가 생길 경우 인터페이스 사용
- else를 지양하자
- 구현 순서도 코딩 컨벤션임을 잊지 말자
- 한 메서드에 한 가지 기능 - 확인하는 기준을 세우자.
- 테스트 작성 이유에 대해 정리하자.
- 테스트는 단위테스트부터 하자