Class ConnectionData
    Public ServerName As String
    Public DatabaseName As String
    Public Security As String
    Public UserID As String
    Public Password As String
    Public sProd As String = My.Application.Info.ProductName

    Public Function CheckConnection() As Boolean
        Dim oConn As New SqlConnection
        If Security = "WIN" Then
            strConn = "Persist Security Info=False;Integrated Security=SSPI;" & _
                "Initial Catalog=" & DatabaseName & ";Server=" & ServerName
        Else
            strConn = "UID=" & UserID & ";Password=" & Password & ";Database=" & _
                DatabaseName & ";Server=" & ServerName & ";"
        End If
        Try
            oConn.ConnectionString = strConn
            oConn.Open()
            oConn.Close()
            Return True
        Catch ex As Exception
            Return False
        End Try
    End Function

    Public Sub SaveToRegistry()
        SaveSetting(sProd, "Setup", "Server", ServerName)
        SaveSetting(sProd, "Setup", "Database", DatabaseName)
        SaveSetting(sProd, "Setup", "Security", Security)
        SaveSetting(sProd, "Setup", "UserID", UserID)
        SaveSetting(sProd, "Setup", "Password", Password)
    End Sub

    Public Sub GetFromRegistry()
        ServerName = GetSetting(sProd, "Setup", "Server", "(local)")
        DatabaseName = GetSetting(sProd, "Setup", "Database", "UNKNOWN")
        Security = GetSetting(sProd, "Setup", "Security", "WIN")
        UserID = GetSetting(sProd, "Setup", "UserID", "sa")
        Password = GetSetting(sProd, "Setup", "Password", "")
    End Sub
End Class

Public strConn As String
Public cnnCom As SqlConnection
Public cdConn As ConnectionData

Public Function OpenConnection() As Boolean
    cnnCom = New SqlConnection
    cnnCom.ConnectionString = strConn
    Try
        cnnCom.Open()
        Return True
    Catch ex As Exception
        MsgBox("Connection Failed!", MsgBoxStyle.Critical)
        Return False
    End Try
End Function

Public Sub CloseConnection()
    If cnnCom Is Nothing AndAlso cnnCom.State = ConnectionState.Open Then
        cnnCom.Close()
        cnnCom = Nothing
    End If
End Sub
