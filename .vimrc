nnoremap ; :
set nu
set ts=2
set expandtab
syntax on
filetype indent on
call pathogen#infect("~/.vim/bundle/{}")
set statusline=%F
set statusline+=%=
set statusline+=%4l
set ignorecase 
set wrapscan
set incsearch
