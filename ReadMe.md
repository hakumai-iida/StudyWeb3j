## はじめに  
ややこしい話は抜きにして、**Android** で **Ethereum** ブロックチェーンへアクセスしてみるサンプルです。  

下記の **web3j** ライブラリを利用させていただいております。  
**<https://github.com/web3j/web3j>**  

----
## 手順  
### ・プロジェクトのビルド
　**StudyWeb3j** フォルダを **Android Studio** で開いてビルドします  
　
### ・動作確認
　**Android** 端末にてアプリを起動し、画面をタップするとテストが開始されます  
　**LogCat** に下記のようなログが表示されるのでソースコードと照らし合わせてご確認ください  

> @ TestWeb3: START...  
> @ [setTarget]  
> @ target=4(Rinkeby)  
> @ [setAccount]  
> @ FOUND KEY FILE: json={"address":"6b0c05013a6c2d8843295416a401ff77ae35cc35","id":"31b4ef2d-4a2b-400e-becf-f8d43bc4e2c4","version":3,"crypto":{"cipher":"aes-128-ctr","cipherparams":{"iv":"a89f98fbb426e3ebab49c7b41c67daea"},"ciphertext":"e4d9ad4ee3b8c58ae3403a1316bf8be57dd504bc53fa1f72980cada2df79e277","kdf":"scrypt","kdfparams":{"dklen":32,"n":4096,"p":6,"r":8,"salt":"31ddb6a4639d7f139030935cb97f58935b96e84e533b2ed5faeb783bff423fbf"},"mac":"ce8a1d334ead52e7d82e1008cdf0582af72d6e4bd3204b81be8ee051ff38672d"}}  
> @ CURRENT ACCOUNT  
> @ ethereumAddress=0x6b0c05013a6c2d8843295416a401ff77ae35cc35  
> @ [checkBalance]  
> @ balance=389979000000000000wei  
> @ [checkSend]  
> @ transaction hash=0x54236a4a0134bddcfe94a4aa93d87f990d9efd02ce13f9b594d59fc1b75a3a97  
> @ [execCheckHelloWorld]  
> @ EXCEPTION e=Unable to execute Ethereum request  
> @ [execDeployHelloWorld]  
> @ DEPLOYED: contractAddress=0x7691d7e0d32083dcb43d0c57a64be0512c091eef  
> @ [execInteractHelloWorld]  
> @ BEFORE: HelloWorld.getWord()=Hello web3j world  
> @ HelloWorld.setWord( Greeting from web3j at Sun Mar 01 15:57:05 GMT+09:00 2020 )  
> @ AFTER: HelloWorld.getWorld()=Greeting from web3j at Sun Mar 01 15:57:05 GMT+09:00 2020  
> @ TestWeb3: FINISHED  

----
## 補足

テスト用のコードが **TestWeb3.java**、簡易ヘルパーが **Web3Helper.java**、イーサリアム上のコントラクトに対応するコードが **HelloWorld.java**となります。  

テストが開始されると、デフォルトで **Rinkeby** テストネットへ接続します。  

初回の呼び出し時であればアカウントを作成し、その内容をアプリのプライベート領域に **key.json** の名前で出力します。二度目以降の呼び出し時は **key.json** からアカウント情報を読み込んで利用します。  

**ETH** の送金テスト、コントラクトのデプロイ／書き込みテストは、対象のアカウントに十分な残高がないと例外が発生します。**LogCat** にアカウント情報が表示されるので、適宜、対象のアカウントに送金してテストしてください。

プロジェクトフォルダ直下にある **sol** は **HelloWorld.java** 生成用の作業フォルダとなり、**web3j** コマンドを使って **.bin**、**.abi** を変換するバッチファイルと、ソースコードである **.sol** が置いてあります。  
アプリに組み込んでいる **web3j** ライブラリのバージョン **4.2.1-android** にあわせて、**<https://github.com/web3j/web3j/releases/tag/v4.2.0>** の **web3j-4.2.0.zip** を利用しています。

----
## メモ
　2020年3月1日の時点で、下記の環境で動作確認を行なっています。  

#### 実装環境
　・**Windows 10**  
　・**Android Studio 3.1.2**  
　・**Java 1.8.0_152**

#### 確認端末
　・**Nexus 6** **Android 7.1.1**  
