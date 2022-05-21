# 1차 과제 제출
---
# :one: 서비스 소개
### 서비스명 : 심포니 (symphony)
### 서비스 한 줄 소개 : 일상을 '음표'로 기록하고 '악보'로 만나보세요

#  :two: 개발 담당 부분
#### [최유리](https://github.com/uxri) : 작곡자 등록 뷰 (SetNameActivity)
#### [김효림](https://github.com/KxxHyoRim) : 악보 뷰 (SymphonyActivity)
#### [정지연](https://github.com/stopkite) : 글쓰기 뷰(PostNoteActivtiy)
#### 공통: 일기 읽기 뷰 (ShowNoteDialog)

#  :three: 코드 컨벤션
## 1. Kotlin Naming Convention

### 1.1. Class
클래스 파일 이름은 UpperCamelCase를 따른다.

#### 1.1.1. Prefix
- Prefix는 해당 클래스와 관련성이 높은 것으로 임의로 작성한다.
##### - EXAMPLE
`MainActivity`  
`SymphonyFragment`

### 1.2. Variable
변수 이름은 lowerCamelCase를 따른다.
##### - EXAMPLE
`viewPagerAdapter`

----

## 2. Resource Naming Convention
### 2.1. ID
View 이름 Pascal Case를 축약하여 Snake Case로 변환한 것을 따르도록 한다.

#### 2.1.1. Prefix
`<WHAT>_<DESCRIPTION>`

|View|Prefix|
|:---:|:---:|
|ImageView|`iv_`|
|TextView|`tv_`|
|EditText|`et`|
|Button, ImageButton|`btn_`|
|RecyclerView|`rv_`|
|Layout|`layout_`|
|FragmentContainerView|`fcv_`|  

##### - EXAMPLE
```xml
@+id/tv_name
@+id/et_title
@+id/btn_complete
```

### 2.2. Layout
Layout의 xml 파일의 이름은 .kt 의 Pascal Case를 Snake Case로 변환하여 사용한다.

#### 2.2.1. Prefix
`<WHAT>_<WHERE>`

|View|Prefix|
|:---:|:---:|
|Activity|`activity_`|
|Fragment|`fragment_`|
|Dialog|`dialog_`|
|Item|`item_`|

##### - EXAMPLE
`SignInActivity.kt` -> `activity_sign_in.xml`  
`SignUpFragment.kt` -> `fragment_sign_up.xml`
`item_user.xml`

### 2.3. Drawable
#### 2.3.1. Prefix
`<WHAT_DESCRIPTION>`

|Drawable|Prefix|
|:---:|:---:|
|Icon|`ic_`|
|Image|`img_`|
|Background|`bg_`|
|Shape|`<shape>_<color>_<radius>_<value>`|

##### - EXAMPLE
```
ic_error.xml
img_default_user.xml
bg_main.xml
rectangle_yellow_radius_20.xml
```

### 2.4. Color
Color의 이름은 Snake Case로 정한다.

##### - EXAMPLE
```xml
<color name="black">#FF000000</color>
<color name="main_blue">#FFFFFFFF</color>
```




#  :four: 브랜치 전략
### main
#### 기준이 되는 브랜치로 최종 작업물을 PR하는 브랜치

### feature/화면명
#### 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 main 브랜치에 Merge
##### ex) feature/set-name

---
# 2차 과제 제출
---
# 1. SetNameActivity
💜 [최유리](https://github.com/uxri)
* [x] 작곡가 이름 작성하고 SymphonyActivity로 전송
* [x] 이름 칸 채워지는 경우 버튼 색 변경 + 버튼 활성화


## 1.1. addTextChangedListener로 내용 채워지는 경우 버튼 색 활성화
```kotlin
private fun setEditTextChangeListener() {
        binding.etName.addTextChangedListener {
            if (binding.etName.text.isEmpty()) {
                binding.btnNameFinish.setBackgroundResource(R.drawable.rectangle_fill_gray_radius_11)
                binding.btnNameFinish.setTextColor(this.getColor(R.color.text_inactive))
            } else {
                binding.btnNameFinish.setBackgroundResource(R.drawable.rectangle_fill_purple_radius_11)
                binding.btnNameFinish.setTextColor(this.getColor(R.color.white))
            }
        }
    }
```

## 1.2. intent로 작곡가 이름 정보 전송
```kotlin
 private fun btnNameFinish() {
        binding.btnNameFinish.setOnClickListener {
            if (binding.etName.text.isNullOrBlank()) {
                Toast.makeText(this, "이름이 입력되지 않았습니다", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SetNameActivity, SymphonyActivity::class.java)
                intent.putExtra("name", binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
```

---

# 2. SymphonyActivity
💜 [김효림](https://github.com/KxxHyoRim)
* [x] 제목 이름 SetNameActivity로부터 받아옴
* [x] 음표 그리기 버튼 클릭 시 PostNoteActivity로 이동
* [x] 각 음표 클릭 시 과거 일기 확인 가능(Dialog)
* [x] 일기 작성 시 dialog로 

## 2.1. SetNameActivity의 이름 입력값 받아오기
```kotlin 
private fun initDrawNoteBtnClick() {
    binding.btnDraw.setOnClickListener {
        val intent = Intent(this, PostNoteActivity::class.java)
        startActivity(intent)
    }
}
```
### 2.2. SetNameActivity의 이름 입력값 받아오기
```xml
 <androidx.recyclerview.widget.RecyclerView
    android:id="@+id/rv_symphony"
    ...
    app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
    app:spanCount="8"
    tools:itemCount="24"
    tools:listitem="@layout/item_note_for_symphony" />
```
```kotlin
    private fun initRvAdapter() {
        binding.rvSymphony.adapter =
            SymphonyAdapter(::onNoteClick).also { symphonyAdapter = it }
    }
```
- Recyclerview GridLayout 사용하여 8개 음표(높은음자리 1, 입력 음표 7) 3줄 작성


# 2-1. Dialog(Symphony, PostNote)
* [x] 각 음표 클릭 시 SymphonyActivity 위에 Dialog 띄움
* [x] 버튼 누르면 악보 완성 dialog 띄움, 닫으면 dialog 꺼지고 SymphonyActivity로 돌아옴

```Kotlin
class DialogUtil(private val dialogMode: Int, private val note: SymphonyNoteData) :
    DialogFragment() {
    private var _binding: DialogNoteDetailBinding? = null
    val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), R.style.DisableDialogBackground)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogNoteDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d(TAG, "onViewCreated: dialog")
        setLayout(view)
        setVisibilityDependOnDialog()
        clickConfirmListener()
    }

    private fun setVisibilityDependOnDialog() {
        when (dialogMode) {
            SHOW_NOTE -> {
                binding.noteData = note // set data
            }
            COMPLETE_POST -> Log.d(TAG, "setVisibilityDependOnDialog: COMPLETE_POST")
        }
    }

    private fun setLayout(view: View) {
        view.layoutParams.width = (resources.displayMetrics.widthPixels * 0.79).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickConfirmListener() {
        binding.btnConfirm.setOnClickListener { dismiss() }
    }

    companion object {
        const val SHOW_NOTE = 0
        const val COMPLETE_POST = 1
    }
}
```

---

# 3. PostNoteActivity
💜 [정지연](https://github.com/stopkite)
* [x] 현재 날짜 가져오기
* [x] 오늘의 음계 선택가능
* [x] 일기(가사) 글로 작성 가능

### 3.1. 현재 날짜 가져오기
```kotlin
 private fun setCurrentDate() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
        val formatted = current.format(formatter)
        binding.tvDate.text = formatted
    }
```

### 3.2. RadioGroup으로 오늘의 음계 선택
```kotlin
...
    private fun getCheckedNote() {
        binding.radioGroupNote.setOnCheckedChangeListener(object :

            RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(radioGroup: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.radio_do -> {
                        checkedNote = CHECK_NOTE_DOE
                    }
                    R.id.radio_mi -> {
                        checkedNote = CHECK_NOTE_MI
                    }
                    R.id.radio_sol -> {
                        checkedNote = CHECK_NOTE_SOL
                    }
                    R.id.radio_si -> {
                        checkedNote = CHECK_NOTE_SI
                    }
                    R.id.radio_rae -> {
                        checkedNote = CHECK_NOTE_RAE
                    }
                    else -> {
                        checkedNote = CHECK_NOTE_DOE
                    }
                }...
```
### 3.3. 일기(가사) 글로 작성 가능
- EditText 이용해 작성

---
# 서버 연결

## 1. RetroFitBuilder
```kotlin
object RetrofitBuilder {

    private const val BASE_URL = "http://3.34.47.13:8000/"

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    private var instance: SymphonyService? = null

    fun getInstance(): SymphonyService {
        return instance ?: synchronized(this) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create<SymphonyService>()
                .also { instance = it }
        }
    }
}
```
http://3.34.47.13:8000/boards - get  
http://3.34.47.13:8000/board - post

## 2. SymponyService
```kotlin
interface SymphonyService {
    @POST("/board")
    fun postBoard(
        @Body body: PostNoteRequest
    ): Call<PostNoteResponse>
}
```

